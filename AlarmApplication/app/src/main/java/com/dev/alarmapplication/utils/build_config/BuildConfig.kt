package com.dev.alarmapplication.utils.build_config


class BuildConfig {
    companion object {
        var BASE_URL = "https://back.cabinetpishsakhte.com/api/"
        var BASE_URL_MAP_IR = "https://map.ir/"
        var BASE_URL_SHAYPOOR = "https://www.sheypoor.com/"
        var BASE_URL_REGISTER_PHONE = "https://back.orinab.com/api/"
        var BASE_URL_IMAGE = "https://back.orinab.com/storage/"
        var BASE_URL_SITE = "https://orinab.com/kitchen-cabinet/"
        var URL_LOG_USER = "https://back.cabinetpishsakhte.com/api/logusers"

        //api
        const val DASHBOARD = "dashboard"
        const val CABINET_KITCHEN = "cabinetkitchen"
        const val CABINET_KITCHEN_SINGLE = "cabinetkitchensingle"
        const val SEARCH_CATEGORY = "search"
        const val MOBILE_VIEW_SHEYPOOR = "mobile-view-sheypoor"
        const val GET_NUMBER_SHEYPOOR = "/api/get-number-sheypoor"
        const val ADV_SUB = "/api/adv-submit"
        const val IMAGE_UPLOAD_DIRVAR_ORINAB = "/api/imageupload"
        const val IMAGE_DELETE_DIRVAR_ORINAB = "/api/imagedelete"
        const val VIEW_ADDRESS = "/api/view-address"
        const val SEND_ADDRESS = "/api/send-address"
        const val VIEW_MILE_FALSE = "/api/viewMiLefalse"
        const val VIEW_MILE_TRUE = "/api/viewMiLeTrue"
        const val SAVE_LOCATION = "/api/savelocation"
        const val GET_LOCATION = "/api/getlocation"
        const val LOG_USER = "/api/logusers"
        const val SEND_TOKEN_FIREBASE = "/api/send_token_firebase"

        // api
        const val REGISTER = "registerapp"
        const val ACTIVATION_CODE = "registerapp"
        const val LOGIN = "login1"
        const val ADD_ARRIVALS = "add-arrivals"
        const val ADD_MISSION = "add-mission"
        const val ADD_LEAVE = "add-leave"
        const val EDIT_REQUEST_SINGLE = "editrequstsingle"
        const val EDIT_REQUEST_SINGLE_CUSTOMER = "editrequstsinglecustomer"
        const val DELETE_REQUEST_SINGLE = "deleterequstcustomer"
        const val VIEW_MILE = "viewMiLe"
        const val VIEW_MILE_SINGLE = "viewMiLeSingle"
        const val VIEW_MILE_SINGLE_USER = "viewMiLeSingleUser"
        const val VIEW_ARRIVALS_USER = "view-arrivals-user"
        const val VIEW_ALL_USER = "view-all-user"


        // api_sheypoor
        const val MY_ADS_ACTIVE_SHAYPOOR = "api/v6.6.0/user/listings?type=active&newInstall=1&flavor=playStore"
        const val MY_ADS_IN_ACTIVE_SHAYPOOR = "api/v6.6.0/user/listings?type=inactive&newInstall=1&flavor=playStore"
        const val CREATE = "api/v6.6.0/listings?flavor=playStore"
        const val IMAGE_UPLOAD = "api/v6.6.0/listings/images"
        const val ALL_CITY = "api/web/locations"
        const val EDIT_ADS = "api/v6.6.0/listings/{id}"
        const val REMOVE_ADS = "api/v6.6.0/user/listings/"
        const val INFO_ADS = "api/v6.6.0/user/listings/{id}"

        //api_open_street_map
        const val REVERS = "reverse"

        //token
        const val TOKEN_MAP = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImRjZjUzNjVmZmUzNGIxOWM5Y2IxOGZjYWFhNjRiNzBjYjI1NmI3ZDMwMjVhNzI5ZDE4NDI0YWQ5MmI5YmZjYjMxMzdmZjFkY2MxNjBmNTQ2In0.eyJhdWQiOiIxMDkxNyIsImp0aSI6ImRjZjUzNjVmZmUzNGIxOWM5Y2IxOGZjYWFhNjRiNzBjYjI1NmI3ZDMwMjVhNzI5ZDE4NDI0YWQ5MmI5YmZjYjMxMzdmZjFkY2MxNjBmNTQ2IiwiaWF0IjoxNjAwNjMyNTkxLCJuYmYiOjE2MDA2MzI1OTEsImV4cCI6MTYwMzIyNDU5MSwic3ViIjoiIiwic2NvcGVzIjpbImJhc2ljIl19.fd-kP-VYpy6vBbTMoSFo_GkuxvdTSHjthJftHZdGRDsH0kcOgYtso_g4ACD6QONUkiRQrndTZjFr-7cpBGIdxIibDh7J8DOaPBJEWF_r74MA-2A3_-BavsAALo313tVhljgR0fCW54_uGPHsiSELMlJq1TegFYH3BAQr4otv05tNLJ0AY_TeG6GRznuD7SDXmp5henZfen1zkliovfGBA-YtLcxacoc4V8-X7hZiK3Vk6vuWF56B7VEahi7E8YxieaO_ZkLJ4M0zD8TiwbMlXz_5LHYrzmHidp5wKarcPD4NXYJ4ZCu0_okxMdpfPgHPfOZYlsAoVd7BQz3jkH7EIw"

        //filed
        const val API_TOKEN = "api_token"


        //emit socket
        const val ADDRESS_EVENT = "address"

        //filed
        const val IDS = "id"
        const val IS_VALID = "isvalid"
        const val NAME = "name"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val CITY = "city"
        const val CATEGORY = "category"
        const val ATTRIBUTES = "attributes[90154]"
        const val USER_TYPE = "userType"
        const val CSRF_KEY = "csrf-key"
        const val ID_SOURCE = "IDSource"
        const val UPLOAD_TOKEN = "uploadToken"
        const val FILE_NAME = "filename"
        const val IMAGE_NAME = "image"
        const val IMAGE_NAME_DIVAR_ORINAB = "file"
        const val TELL = "tell"
        const val CODE = "code"
        const val USER_NAME = "username"
        const val DEVICE_NAME = "device_name"
        const val USER_TELL = "UserTell"
        const val DATE = "date"
        const val DATE_START = "date_start"
        const val DATE_END = "date_end"
        const val ADDRESS = "address"
        const val LOCATION = "location"
        const val STATE = "state"
        const val USER_ID = "user_id"
        const val DESC = "desc"
        const val DESC_MANAGE = "desc_manage"
        const val TYPE = "type"
        const val TOKEN_FIREBASE = "token_firebase"

        //type_value
        const val TYPE_LEAVE = "Leave"
        const val TYPE_MISSION = "Mission"

        //filed_value
        const val CATEGORY_VALUE = 44240
        const val PHOTO_VALUE = "photo"

        //header
        const val X_API_KEY = "x-api-key"
        const val X_AUTHORIZATION = "X-Authorization"
        const val AUTHORIZATION = "Authorization"
        const val BEARER = "Bearer "
        const val X_TICKET = "x-ticket"

        //query
        const val URL = "url"
        const val Q = "q"
        const val LAT = "lat"
        const val LON = "lon"
        const val TEXT = "text"
        const val FILTER = "filter"
        const val FILTER_DISTANCE = "type eq distance"
        const val ORIGINS = "origins"
        const val DESTINATIONS = "destinations"

        //query_defualt
        const val JSON_V2 = "jsonv2"


        // mapbox
        const val STYLE_MAP_BOX = "https://tile.snappmaps.ir/styles/snapp-style/style.json"
        const val ZOOM_MAP = 15.0
        const val DURATION_ANIMATION = 7000

        //path
        const val ID = "id"

        // validation
        const val START_PHONE_NUMBER_VALIDATION = "09"

        // table
        const val SAVE_LOCATION_ENTITY = "save_location"
        const val USER_ENTITY = "user_entity"
        const val USER_REPORT_ENTITY = "user_report"
        const val REGISTER_PHONE_ENTITY = "register_phone_entity"

        // state
        const val STATE_ACCOUNT = "display_user_information"
        const val STATE_CHANGE_PASSWORD = "change_password"
        const val STATE_WALLET = "wallet"
        const val STATE_MY_PAYMENT = "my_payments"
        const val STATE_MY_ADDRESSES = "my_addresses"
        const val STATE_MY_TRAVELS = "my_travels"
        const val STATE_EXIT = "exit"

        //state
        const val FAIL = "fail"

        //json
        const val TYPE_LEAVE_LIST = "lottie/type_leave_list.json"
        const val TYPE_MISSION_LIST = "lottie/type_mission_list.json"

        //map_box
        const val ROUTE_SOURCE_ID = "route-source-id"
        const val ROUTE_LAYER_ID = "route-layer-id"
        const val ICON_LAYER_ID = "icon-layer-id"
        const val ICON_SOURCE_ID = "icon-source-id"
        const val RED_PIN_ICON_ID = "red-pin-icon-id"


        // database
        const val USER_DATABASE = "user_database"

        //request_code
        const val TYPE_VALID_FAIL = 3
        const val TYPE_VALID_APPROVAL = 2


        //request_code
        const val REQUEST_USER_CONSENT = 100
        const val REQUEST_LOCATION_PERMISSION = 200
        const val REQUEST_GOOGLE_SEARCH_PERMISSION = 300
        const val GPS_SETTINGS = 0x7

        //timer
        const val TIMER = 90000
        const val COUNT_DOWN_INTERNAL = 1000

        //date
        const val MIN_YEAR_DATE = 1401
        const val PERSIAN_DATE = 1401
        const val PERSIAN_MONT = 1
        const val PERSIAN_DAY = 1


        //state_marker
        const val PAGE = "1"

        // request_location
        const val INTERVAL = (1000 * 300).toLong()
        const val FASTEST_INTERVAL = (1000 * 200).toLong()
        const val DEFAULT_INTERVAL_IN_MILLISECONDS = 1L
        const val DEFAULT_MAX_WAIT_TIME = DEFAULT_INTERVAL_IN_MILLISECONDS * 1

        const val API_DEFAULT_INTERVAL_IN_MILLISECONDS = 1L
        const val API_DEFAULT_MAX_WAIT_TIME = API_DEFAULT_INTERVAL_IN_MILLISECONDS * 1

        const val TIME_INTERVAL_IN_SECONDS = 10L

        //type_adapter
        const val TYPE_INT_SHOW_ITEM = 105
        const val TYPE_INT_SHOW_LOADING = 106

        const val TYPE_SHOW_ITEM = "show_item"
        const val TYPE_SHOW_LOADING = "show_loading"

        // bundle
        const val BUNDLE_ID = "id"
        const val BUNDLE_ACCOUNT_SHAYPOOR = "AccountShaypoor"
        const val BUNDLE_VIEW_MILE_USER = "ViewMileUser"
        const val BUNDLE_ARRIVALS_AND_DEPARTURES = "arrivalsAndDepartures"
        const val BUNDLE_VIEW_ALL_MODEL = "ViewAllUserModel"

        const val BUNDLE_ALARM_HOURS = "alarm_hours"
        const val BUNDLE_ALARM_MINUTES = "alarm_minutes"
        const val BUNDLE_ALARM_PROGRESS = "alarm_progress"
        const val ERROR_BUNDLE = "error"
        const val LOGIN_BUNDLE = "login"
        const val PHONE_NUMBER_BUNDLE = "phone_number"
        const val BROADCAST_UPLOAD_FILE_BUNDLE = "result_broadcast"
        const val BROADCAST_UPLOAD_FILE_ERROR_BUNDLE = "result_broadcast_error"
        const val BROADCAST_FILE_PATH_BUNDLE = "file_path"
        const val VOICE_LIST_BUNDLE = "voice_list"
        const val CONTENTS_BUNDLE = "contents"
        const val COUNTER_BUNDLE = "counter_bundle"

        //edit_text
        const val EMPTY_VALUE = ""

        //persian_date
        const val PATTERN_DATE_TIMEZONE = "yyyy-MM-dd HH:mm:ss"
        const val PATTERN_DATE = "yyyy-MM-dd"

        //type_sheypoor
        const val LISTING = "LISTING"

        //cost_id_product
        const val CONST_ALL_PRODUCT = 5

        // extra
        const val EXTRA_ALARM_ID = "EXTRA_ALARM_ID"


        // tag
        const val TAG_POWER_SERVICE = "POWER_SERVICE"
        const val TAG_MY_WORK = "TAG_MY_WORK"


        // key param
        const val API_IMAGE_PARAM = "cover"
        const val API_IMAGE_PARAM_AVATAR = "avatar"

        // notification
        const val CHANNEL_REPORT_ID = "channel1"
        const val CHANNEL_REPORT_NAME = "hello"
        const val CHANNEL_GPS_ID = "CHANNEL_GPS_ID"
        const val CHANNEL_GPS_NAME = "CHANNEL_GPS_NAME"

        // size image
        const val MAX_WIDTH = 1920
        const val MAX_HEIGHT = 1080
        const val RESULT_CODE_TAKE_GALLERY = 19920
        const val RESULT_CODE_TAKE_CAMERA = 19910
        const val RESULT_CODE_UCROP = 100004
        const val MY_PERMISSIONS_REQUEST_LOCATION = 1001
        const val REQUEST_ID_MULTIPLE_PERMISSIONS = 1002
        const val REQUEST_ID_STORAGE_PERMISSIONS = 1003

        //attribute
        const val ATTRIBUTE_ID_1 = 1
        const val ATTRIBUTE_VALUE_1 = "12345"
        const val ATTRIBUTE_ID_2 = 90154
        const val ATTRIBUTE_VALUE_2 = "453187"
        const val ATTRIBUTE_ID_3 = 75023
        const val ATTRIBUTE_VALUE_3 = ""

    }
}