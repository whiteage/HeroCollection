package com.example.herocollection.viewmodel

object Logos{
    private const val DEFAULT_LOGO_URL = "https://amt-zap.ru/wp-content/uploads/2024/01/question-mark-svgrepo-com.png"
    val comicsPublishers = mapOf(
        "Marvel Comics" to "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Marvel_Logo.svg/1200px-Marvel_Logo.svg.png",
        "DC Comics" to "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/DC_Comics_logo.svg/1200px-DC_Comics_logo.svg.png",
        "Image Comics" to "https://yastatic.net/naydex/yandex-search/KcM5dI930/1f9e5c-yAk/zvPjNzm610qdI31zmXWpRNe8e_shtAQD3mi0e5XM4IoGIhnyUE2kfV2UNmMcSZQtXEwNx6LcSKSSyjv_eOQ_GufT1hQUhqtuvhkdc5l1qUTXvGfrCsQ",
        "Dark Horse Comics" to "https://avatars.mds.yandex.net/i?id=8bbad63e8ae9f1438f235c52a884927e_l-3163703-images-thumbs&n=13",
        "IDW Publishing" to "https://static.wikia.nocookie.net/idwrevolution/images/c/c9/IDW-Publishing-Logo.jpg/revision/latest/scale-to-width-down/1200?cb=20160905215445",
        "Boom! Studios" to "https://static.wikia.nocookie.net/memoryalpha/images/c/ce/Boom_Studios_logo.jpg/revision/latest/scale-to-width-down/1200?cb=20150826013048&path-prefix=en",
        "Valiant Comics" to "https://i.imgur.com/vVp3TQo.png",
        "Dynamite Entertainment" to "https://www.clipartmax.com/png/middle/444-4444632_dynamite-entertainment-comics-logo.png",
        "Archie Comics" to "https://yandex-images.clstorage.net/4MvEr9251/2702bezSa/D53_kVRrV64SefV5dPlmheAihMuU5lb7fTb5lWXoWyrMJDZUIfmqovjYmAcCKJerQ7v21SiY7TERYz80X7IY5gKd79BlckvPdwjZJCTZapHoV_HH0Jc-6glf8OQI6GpPrCF2vMQYfjNkaTS6091Km1-Os4gNtfFp9M93kVqanf6rpW_9_OMGLu5lhNn0YcbxTOsA57gjAgJZgsgAHD1eygkALviEwC5bDAEwzmtlIr_DOrNU3GmFibymQwmS2m2WV-W3oewfzsKG9diNgEkOXeR3jOMQu65SsUaI5HA9CvLVBGYYAIQmFyDRxFarzaqrYyK_XKQtLX2sduPpXhZVqiutfwHIb1oeDgmcWailFllUe2RnVPdWktEuMCR4OZ4qDURiGFC4Nj_AacQak_Fi-zMmN8zETSmpvGLnrR5yXYI_Saf9xB82NvZZnCU0eeqRSNsYIxAjCmKNegy8OA1KHvUM9myYvB5rhJlMWmMRUj_v6nugBCEVZcD-Y3WOYt2Cswm7RbBryloutagp8MXCHfhLBK9g4-bKuVbw2HxlguaF8H7IiAwe81wJ0JpLzZbHO44vTEi9hVWoKl-VjrK5fmPZQ4GwO866Iu3QJcw55iXsA7Rv6Cfa7sW-2ND8jcpWCVCmKBDAOmNQNSSqf_E278MyhyCo1bU1WPKj4ZLybX4T0b9JCD-qKsIlWH0E6YZ1rKPwK8h_8lIlWniIkIkSsrEAGhDQlPILFF2UGss12tuHmvcwVG2dOYCeyyk-ZjU6S-m7YeRLlgr2ufhhqG1-9UCr1HfUP24-3XKoXAStEjJlNGZYnHyug0xB5K5DySK7R64zAGhpKQnYcqOxYnbB6mvBk01km0JGxlEESXixSrVcb4SnIJe2kt0qiNwoYZpyveBi6LysnjO4EWj643HKZ4eSm4zo3eV53FZjNdJmbSonidMRDP-62nat5JksvVa5tMtk9xCvwtKhOvjoFDWY",
        "Oni Press" to "https://i.imgur.com/kL8mRnU.png",
        "Universal Television" to "https://yastatic.net/naydex/yandex-search/6zeVDU892/97a9c4r8C/CfT12mjyqFturcrStivWNibevfCn-ZMmj1IOQbR2IhyAhWhKqDEffwWIBjIVcvDCKTLbx1ogePmsGN8rrsLCXtlQDQ7oMhnfkhkbTmpL6h4iq-Tw-_xTx",
        "Radical Entertainment" to "https://commons.wikimedia.org/wiki/File:Radical_Entertainment_logo.svg?uselang=ru",

    )


    fun getLogo(studio: String?): String {
        return comicsPublishers[studio] ?: DEFAULT_LOGO_URL
    }
}