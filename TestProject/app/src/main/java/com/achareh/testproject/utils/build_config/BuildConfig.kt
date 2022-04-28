package com.achareh.testproject.utils.build_config


class BuildConfig {
    companion object {
        var BASE_URL = "https://stage.achareh.ir/api/"
        var BASE_URL_MAP_IR = "https://map.ir/"

        //token
        const val TOKEN_MAP = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImRjZjUzNjVmZmUzNGIxOWM5Y2IxOGZjYWFhNjRiNzBjYjI1NmI3ZDMwMjVhNzI5ZDE4NDI0YWQ5MmI5YmZjYjMxMzdmZjFkY2MxNjBmNTQ2In0.eyJhdWQiOiIxMDkxNyIsImp0aSI6ImRjZjUzNjVmZmUzNGIxOWM5Y2IxOGZjYWFhNjRiNzBjYjI1NmI3ZDMwMjVhNzI5ZDE4NDI0YWQ5MmI5YmZjYjMxMzdmZjFkY2MxNjBmNTQ2IiwiaWF0IjoxNjAwNjMyNTkxLCJuYmYiOjE2MDA2MzI1OTEsImV4cCI6MTYwMzIyNDU5MSwic3ViIjoiIiwic2NvcGVzIjpbImJhc2ljIl19.fd-kP-VYpy6vBbTMoSFo_GkuxvdTSHjthJftHZdGRDsH0kcOgYtso_g4ACD6QONUkiRQrndTZjFr-7cpBGIdxIibDh7J8DOaPBJEWF_r74MA-2A3_-BavsAALo313tVhljgR0fCW54_uGPHsiSELMlJq1TegFYH3BAQr4otv05tNLJ0AY_TeG6GRznuD7SDXmp5henZfen1zkliovfGBA-YtLcxacoc4V8-X7hZiK3Vk6vuWF56B7VEahi7E8YxieaO_ZkLJ4M0zD8TiwbMlXz_5LHYrzmHidp5wKarcPD4NXYJ4ZCu0_okxMdpfPgHPfOZYlsAoVd7BQz3jkH7EIw"


        //header
        const val CONTENT_TYPE = "Content-Type"
        const val AUTHORIZATION = "Authorization"
        const val X_API_KEY = "x-api-key"

        //header_value
        const val CONTENT_TYPE_VALUE = "application/json"
        const val AUTHORIZATION_USER_NAME = "09822222222"
        const val AUTHORIZATION_PASSWORD = "Sana12345678"

        //api
        const val ADDRESS = "karfarmas/address"

        //api_open_street_map
        const val REVERS = "reverse"

        //query
        const val LAT = "lat"
        const val LON = "lon"

        // mapbox
        const val STYLE_MAP_BOX = "https://tile.snappmaps.ir/styles/snapp-style/style.json"
        const val ZOOM_MAP = 15.0
        const val DURATION_ANIMATION = 7000

        // validation
        const val START_PHONE_NUMBER_VALIDATION = "09"

        // gender
        const val FEMALE = "Female"
        const val MALE = "Male"

    }
}