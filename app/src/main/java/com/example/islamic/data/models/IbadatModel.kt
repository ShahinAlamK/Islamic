package com.example.islamic.data.models

data class ItemModel(
    val title: String = "",
    val items: List<IbadatModel> = emptyList()
)

data class IbadatModel(
    var title: String = "",
    val bangla: String = "",
    var arabic: String = "",
    var meaning: String = ""
)


val itemList = listOf(


    ItemModel(
        title = "ছোট ছোট সূরা",
        items = listOf(
            IbadatModel(
                title = "সূরা আন নাস",
                bangla = "কুল আ‘ঊযুবিরাব্বিন্না-ছ, মালিকিন্না-ছ, ইলা-হিন্না-ছ। মিন শাররিল ওয়াছ ওয়া-ছিল খান্না-ছ। আল্লাযী ইউওয়াছবিছুফী সুদূরিন্নাছ-। মিনাল জিন্নাতি ওয়ান্না-ছ।",
                arabic = "قُلْ أَعُوذُ بِرَبِّ ٱلنَّاسِ مَلِكِ ٱلنَّاسِ إِلَٰهِ ٱلنَّاسِ مِن شَرِّ ٱلْوَسْوَاسِ ٱلْخَنَّاسِ ٱلَّذِى يُوَسْوِسُ فِى صُدُورِ ٱلنَّاسِ مِنَ ٱلْجِنَّةِ وَٱلنَّاسِ",
                meaning = "বলুন, আমি আশ্রয় গ্রহণ করিতেছি মানুষের পালনকর্তার,মানুষের অধিপতির, মানুষের মা’বুদের তার অনিষ্ট থেকে, যে কুমন্ত্রণা দেয় ও আত্নগোপন করে, যে কুমন্ত্রণা দেয় মানুষের অন্তরে জ্বিনের মধ্য থেকে অথবা মানুষের মধ্য থেকে।"
            )
        )
    ),

    ItemModel(
        title = "তওবা করার দোয়া",
        items = listOf(
            IbadatModel(
                title = "সায়্যিদুল ইসতেগফার",
                bangla = "\n",
                arabic = "َ\n",
                meaning = ""
            ),
            IbadatModel(
                title = "তওবা করার দোয়া",
                bangla = "আসতাগফিরুল্লা-হাল্লাযী লা-ইলা-হা ইল্লা হুওয়াল হা’ইয়ুল ক্বাইয়ূমু ওয়া আতুবু ইলাইহি।\n",
                arabic = "أَسْتَغْفِرُ اللَّهَ الَّذِي لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ القَيّوُمُ وَأَتُوبُ إِلَيهِ\n",
                meaning = "মহান আল্লাহর কাছে আমি ক্ষমা চাই, যিনি ছাড়া কোনো উপাস্য নেই, যিনি চিরঞ্জীব, চিরস্থায়ী এবং আমি তাঁর কাছে তওবা করি।’ জায়দ (রা.) রাসুল (স.)-কে বলতে শুনেছেন, যে ব্যক্তি এই দোয়া পড়ে, তাকে ক্ষমা করে দেওয়া হয়, যদিও সে রণক্ষেত্র থেকে পলায়ন করে থাকে। "
            ),
        )
    ),

    ItemModel(
        title = "ছোট ছোট দোয়া",
        items = listOf(

            IbadatModel(
                title = "দোয়া কুনুত",
                bangla = "আল্লাহুম্মা ইন্না নাসতায়িনুকা ওয়া নাসতাগ ফিরুকা, ওয়ানু’মিনু বিকা ওয়া নাতাওয়াক্কালু আলাইকা ওয়া নুছনি আলাইকাল খাইর। ওয়া নাসকুরুকা ওয়ালা নাক ফুরুকা, ওয়ানাখলাউ উয়ানাত রুকু মাইয়্যাফযুরুকা। আল্লাহুম্মা ইয়্যাকানা’বুদু ওয়ালাকা নুছল্লি, ওয়ানাস জুদু ওয়া ইলাইকা নাসয়া; ওয়া নাহফিদু ওয়া নারজু রাহমাতাকা, ওয়া নাখশা আজাবাকা; ইন্না আজাবাকা বিলকুফফারি মুলহিক্।",
                arabic = "اَللَّهُمَّ اِنَّ نَسْتَعِيْنُكَ وَنَسْتَغْفِرُكَ وَنُؤْمِنُ بِكَ وَنَتَوَكَّلُ عَلَيْكَ وَنُثْنِىْ عَلَيْكَ الْخَيْرَ وَنَشْكُرُكَ وَلاَ نَكْفُرُكَ وَنَخْلَعُ وَنَتْرُكُ مَنْ يَّفْجُرُكَ-اَللَّهُمَّ اِيَّاكَ نَعْبُدُ وَلَكَ نُصَلِّىْ وَنَسْجُدُ وَاِلَيْكَ نَسْعَى وَنَحْفِدُ وَنَرْجُوْ رَحْمَتَكَ وَنَخْشَى عَذَابَكَ اِنَّ عَذَابَكَ بِالْكُفَّارِ مُلْحِقٌ",
                meaning = "হে আল্লাহ! আমরা তোমারই সাহায্য চাই। তোমারই নিকট ক্ষমা চাই, তোমারই প্রতি ঈমান রাখি, তোমারই ওপর ভরসা করি এবং সকল মঙ্গল তোমারই দিকে ন্যস্ত করি। আমরা তোমার কৃতজ্ঞ হয়ে চলি, অকৃতজ্ঞ হই না। হে আল্লাহ! আমরা তোমারই দাসত্ব করি, তোমারই জন্য নামাজ পড়ি এবং তোমাকেই সিজদাহ করি। আমরা তোমারই দিকে দৌড়াই ও এগিয়ে চলি। আমরা তোমারই রহমত আশা করি এবং তোমার আযাবকে ভয় করি। আর তোমার আযাবতো কাফেরদের জন্যই র্নিধারিত।"
            ),
            IbadatModel(
                title = "বিপদ থেকে বাঁচতে দোয়া",
                bangla = " ‘লা ইলাহা ইল্লা আনতা সুবহানাকা ইন্নি কুনতু মিনাজ জ্বলিমিন।’",
                arabic = "لَا اِلَهَ اِلَّا اَنْتَ سُبْحَانَكَ اِنِّى كَنْتُ مِنَ الظَّالِمِيْنَ",
                meaning = "হে আল্লাহ! তুমি ছাড়া কোনো সত্য উপাস্য নেই; আমি তোমার পবিত্রতা বর্ণনা করছি। নিঃসন্দেহে আমি জালিমদের অন্তর্ভুক্ত।’ (তিরমিজি)"
            ),
            IbadatModel(
                title = "নেককার স্ত্রী পাওয়ার দোয়া",
                bangla = "‘রাব্বানা হাব্লানা মিন আযওয়াঝিনা ওয়া জুর্রিয়াতিনা কুর্রাতা আইয়ুনিও ওয়াঝআলনা লিলমুত্তাক্বিনা ইমামা।’",
                arabic = "رَبَّنَا هَبْ لَنَا مِنْ أَزْوَاجِنَا وَذُرِّيَّاتِنَا قُرَّةَ أَعْيُنٍ وَاجْعَلْنَا لِلْمُتَّقِينَ إِمَامًا",
                meaning = "‘হে আমাদের প্রতিপালক! আপনি আমাদের এমন স্ত্রী ও সন্তান দান করুন। যারা আমাদের চোখ জুড়িয়ে দেয় আর আমাদেরকে (পুরুষদেরকে) মুত্তাকি লোকদের নেতা বানিয়ে দাও।’ (সুরা ফুরক্বান : আয়াত ৭৪)"
            ),
            IbadatModel(
                title = "কবর আজাব থেকে আশ্রয় চেয়ে কান্না ও দোয়া",
                bangla = "আল্লাহুম্মা ইন্নি আউজুবিকা মিন আজাবি জাহান্নাম, ওয়া মিন আজাবিল কাবর, ওয়া মিন ফিতনাতিল মাহয়িয়া ওয়াল মামাতি ওয়া মিন শাররি ফিতনাতিল মাসিহিদ দাজ্জাল।’",
                arabic = "اَللَّهُمَّ إِنِّيْ أَعُوْذُ بِكَ مِنْ عَذَابِ جَهَنَّمَ،  وَمِنْ عَذَابِ الْقَبْرِ،  وَمِنْ فِتْنَةِ الْمَحْيَا وَالْمَمَاتِ، وَمِنْ شَرِّ فِتْنَةِ الْمَسِيْحِ الدَّجَّالِ\n",
                meaning = "‘হে আল্লাহ! আমি তোমার কাছে জাহান্নামের আজাব থেকে আশ্রয় চাই। কবরের আজাব থেকে আশ্রয় চাই। জীবন-মৃত্যুর ফিতনা থেকে আশ্রয় চাই। আর মাসিহ দাজ্জালের ফিতনার ক্ষতি থেকে আশ্রয় চাই।’ (মুসলিম)"
            ),
            IbadatModel(
                title = "গোনাহ মাফের দোয়া",
                bangla = "লা ইলাহা ইল্লাল্লাহু, ওয়াহদুহু লা শারিকা লাহু, লাহুল মুলকু ওয়া লাহুল হামদু ওয়া হুয়া আলা কুল্লি শায়্যিন ক্বাদির। আল হামদু লিল্লাহি, ওয়া সুবহানাল্লাহি, ওয়া লা ইলাহা ইল্লাল্লাহু, ওয়াল্লাহু আকবার, ওয়া লা হাওলা ওয়া লা কুয়্যাতা ইল্লা বিল্লাহ।’",
                arabic = "لَا إلَهَ إلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ، وَلَهُ الْحَمْدُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ\n",
                meaning = "আল্লাহ ছাড়া কোনো ইলাহ নেই, তিনি একক, তাঁর কোনো শরিক নেই, রাজত্ব একমাত্র তাঁরই, সব প্রশংসা একমাত্র তাঁরই জন্য, আর তিনি সব কিছুর ওপর ক্ষমতাবান।"
            ),

            )
    )

)


