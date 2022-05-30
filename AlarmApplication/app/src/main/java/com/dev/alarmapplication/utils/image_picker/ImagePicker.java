package com.dev.alarmapplication.utils.image_picker;

import static com.dev.alarmapplication.BuildConfig.APPLICATION_ID;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.dev.alarmapplication.R;
import com.dev.alarmapplication.interfaces.OnCreateCameraImageFile;
import com.dev.alarmapplication.utils.tools.HandleErrorTools;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.util.Objects;


public class ImagePicker {

    public static final int RC_PERMISSION_REQUEST_CAMERA = 24;
    private Context context;
    private int maxWidth;
    private int maxHeight;
    private boolean square;
    public final static int RESULT_CODE_TAKE_GALERY = 19920;
    public final static int RESULT_CODE_TAKE_CAMERA = 19910;
    public final static int RESULT_CODE_PRIMATION = 20180;
    public final static int RESULT_CODE_CROP_FROM_URL = 13710;
    public final static int RESULT_CODE_CROP_FROM_URL_PREMATION = 13970;
    private String fileName;
    private Uri cameraUri;
    private final HandleErrorTools handelErrorTools;

    public ImagePicker() {
        handelErrorTools = new HandleErrorTools();
    }

    public void setImagePicker(Context context, int maxWidth, int maxHeight, boolean square) {
        this.context = context;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.square = square;
    }


    public void getImageAndStorage(String FileName) {
        fileName = FileName;

        if (isReadStoragePermissionGranted()) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("InflateParams") View view = Objects.requireNonNull(inflater).inflate(R.layout.bottom_sheet_imagepicker, null);
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();
            View fabGallery = bottomSheetDialog.findViewById(R.id.fabGallery);
            View fabCamera = bottomSheetDialog.findViewById(R.id.fabCamera);
            Objects.requireNonNull(fabGallery).setOnClickListener(v -> {
                pickFromGallery();
                bottomSheetDialog.dismiss();
            });
            Objects.requireNonNull(fabCamera).setOnClickListener(v -> {
                pickFromCamera(createCameraImageFile());
                bottomSheetDialog.dismiss();
            });
        }
    }


    public Uri getCameraUri() {
        return cameraUri;
    }

    private void pickFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT)
                .setType("image/*")
                .addCategory(Intent.CATEGORY_OPENABLE);

        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);

        ((AppCompatActivity) context).startActivityForResult(Intent.createChooser(intent,
                context.getString(R.string.label_select_picture)), RESULT_CODE_TAKE_GALERY);
    }

    public void pickFromCamera(Uri uri) {
        if (checkPermission()) intentCamera(uri);
        else requestPermission();


    }

    private void requestPermission() {
        ActivityCompat.requestPermissions((Activity) context,
                new String[]{Manifest.permission.CAMERA},
                RC_PERMISSION_REQUEST_CAMERA);
    }

    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    private void intentCamera(Uri uri) {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (pictureIntent.resolveActivity(context.getPackageManager()) != null) {
            pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            ((AppCompatActivity) context).startActivityForResult(pictureIntent, RESULT_CODE_TAKE_CAMERA);
        }
    }

    public void handelCrop(Uri uri, int requestCode) {
        if (isReadStoragePermissionGranted(RESULT_CODE_CROP_FROM_URL_PREMATION))
            if (uri != null) {
                Uri uri1 = Uri.fromFile(createFile(fileName));
                UCrop uCrop = UCrop.of(uri, uri1);
                UCrop.Options options = new UCrop.Options();
                options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
                options.setCompressionQuality(UCropActivity.DEFAULT_COMPRESS_QUALITY);
                options.withMaxResultSize(maxWidth, maxHeight);
                if (square) options.withAspectRatio(1, 1);
                options.setFreeStyleCropEnabled(!square);
                options.setCropGridColumnCount(0);
                options.setCropGridRowCount(0);
                uCrop = uCrop.withOptions(options);
                uCrop.start((AppCompatActivity) context, requestCode);
            }

    }

    public void handelCrop(Uri uri) {
        if (uri != null) {
            UCrop uCrop = UCrop.of(uri, Uri.fromFile(createFile(fileName)));
            UCrop.Options options = new UCrop.Options();
            options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
            options.setCompressionQuality(UCropActivity.DEFAULT_COMPRESS_QUALITY);
            options.withMaxResultSize(maxWidth, maxHeight);
            if (square) options.withAspectRatio(1, 1);
            options.setFreeStyleCropEnabled(!square);
            options.setCropGridColumnCount(0);
            options.setCropGridRowCount(0);
            uCrop = uCrop.withOptions(options);
            uCrop.start((AppCompatActivity) context, UCrop.REQUEST_CROP);
        }

    }

    public Uri handelCropResult(@NonNull Intent result) {
        return UCrop.getOutput(result);
    }

    public void callBackCreateCameraImageFile(OnCreateCameraImageFile onCreateCameraImageFile) {
        onCreateCameraImageFile.createCameraImageFile(createCameraImageFile());
    }

    public Uri createCameraImageFile() {
        try {
            File file = createFile(".temp");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                if (file != null)
                    cameraUri = FileProvider.getUriForFile(context, APPLICATION_ID + ".provider", file);
            } else
                cameraUri = Uri.fromFile(file);

        } catch (Exception e) {
            handelErrorTools.handleError(e);
        }
        return cameraUri;

    }

    private File createFile(String fileName) {
        try {
            if (fileName == null) {
                fileName = "img_" + System.currentTimeMillis();
            }
            File fileDir = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES);
            if (!fileDir.exists())
                fileDir.mkdir();

            File fileDir2 = new File(fileDir + File.separator + "zoomila");
            if (!fileDir2.exists())
                fileDir2.mkdir();

            File file = new File(fileDir2, fileName + ".jpg");
            if (!file.exists())
                file.delete();

            return file;
        } catch (Exception e) {
            handelErrorTools.handleError(e);

        }
        return null;
    }

    public boolean removeFile(String fileName) {
        try {
            File fileDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (!fileDir.exists())
                return false;

            File fileDir2 = new File(fileDir + File.separator + "zoomila");
            if (!fileDir2.exists())
                return false;

            File file = new File(fileDir2, fileName);
            if (file.exists())
                file.delete();

            return true;
        } catch (Exception e) {
            handelErrorTools.handleError(e);
            return false;
        }
    }

    private boolean isReadStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                return true;
            else {
                ActivityCompat.requestPermissions((AppCompatActivity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, RESULT_CODE_PRIMATION);
                return false;
            }
        } else
            return true;
    }

    private boolean isReadStoragePermissionGranted(int RequestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                return true;
            else {
                ActivityCompat.requestPermissions((AppCompatActivity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, RequestCode);
                return false;
            }
        } else
            return true;
    }

}
