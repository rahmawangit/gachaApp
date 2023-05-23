package com.example.gacha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.example.gacha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var izinGacha = false
    // VAR BUAT NAMPUNG NILAI EXCLUDE
    var ex_areef: Int = 0; var ex_jae: Int = 0; var ex_ray: Int = 0; var ex_bags: Int = 0;
    var ex_eureka: Int = 0; var ex_samsul: Int = 0; var ex_debo: Int = 0; var ex_jalex: Int = 0;
    var ex_sativa: Int = 0; var ex_kei: Int = 0; var ex_mabar: Int = 0; var ex_ajiDipo: Int = 0;
    var ex_azis: Int = 0; var ex_jakha: Int = 0; var ex_aji: Int = 0; var ex_panji: Int = 0;
    var ex_limit: Int = 14;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        checkBox()

        // BUTTON CLICKED
        binding.buttRoll.setOnClickListener() {
               letsGooooooooooo()
        }
        binding.buttReset.setOnClickListener() {
            resetDefault()
        }
        setContentView(binding.root)
    }

    // NAMA PESERTA BLK MAT,
    private fun namaPelakuGacha(id_pemenang: Int): String {
        var winner: String
        when (id_pemenang) {
            1 -> winner = "Areef"
            2 -> winner = "Jae"
            3 -> winner = "Ray"
            4 -> winner = "Bagas"
            5 -> winner = "Fatma"
            6 -> winner = "Samsul"
            7 -> winner = "Debora"
            8 -> winner = "Rizal"
            9 -> winner = "Sativa"
            10 -> winner = "Kei"
            11 -> winner = "Bakal"
            12 -> winner = "Aji_d"
            13 -> winner = "Aji_s"
            14 -> winner = "Aji_f"
            15 -> winner = "Azis"
            16 -> winner = "Jakha"
            else -> winner = "None"
        }
        return winner
    }

    // POP UP MESSAGE
    private fun ToastMessage(keterangan: String) {
        val toast = Toast.makeText(this, "$keterangan", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 100, 50)
        toast.show()
    }

    // CEK YANG GA MAU GACHA, BIAR LIMITNYA SESUAI
    private fun cek_exclude(ex_limit_para: Int): Boolean {
        if (ex_limit_para == 0 || ex_limit_para < 0) {
            ToastMessage("Niat Gacha Ga Sih?!!")
            return false
        } else {
            ex_limit--
            return true
        }
    }

    // GET VALUE NO ABSEN (BUAT LOGIC)
    private fun keputusan_exclude(valueKeputusan: Boolean, nomorAbsen: Int): Int {
        if (valueKeputusan == true) {
            return nomorAbsen
        } else {
            return 0
        }
    }

    // CHECKBOX
    private fun checkBox() { // CHECBOX MASING MASING
        // IF METHOD
        var catchValue: Boolean;
        binding.HArief.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked == true) {
                catchValue = cek_exclude(ex_limit) // BUAT CEK CHECKBOXNYA MASIH ADA SLOT EXCLUDE / TIDAK
                binding.HArief.setChecked(catchValue); // KEPUTUSAN CHECKBOX TER CHECKED ATAU TIDAK
                ex_areef = keputusan_exclude(catchValue, 1)
                Log.d("CHECKBOXES", "IF is checked: $isChecked + $ex_limit")
            } else if (isChecked == false) {
                ex_areef = 0
                ex_limit++
            }
        }
        // WHEN 1st METHOD
        binding.HBagas.setOnCheckedChangeListener { buttonView, isChecked ->
            when (isChecked) {
                true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HBagas.setChecked(catchValue); // KEPUTUSAN CHECKBOX TER CHECKED ATAU TIDAK VERSI CEPAT
                    ex_bags = keputusan_exclude(catchValue, 4)
                }

                false -> {
                    ex_bags = 0
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        // WHEN 2nd METHOD
        binding.HJae.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HJae.setChecked(catchValue);
                    ex_jae = keputusan_exclude(catchValue, 2)
                }

                isChecked == false -> {
                    ex_jae = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HRay.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HRay.setChecked(catchValue);
                    ex_ray = keputusan_exclude(catchValue, 3)
                }

                isChecked == false -> {
                    ex_ray = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HFatma.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HFatma.setChecked(catchValue);
                    ex_eureka = keputusan_exclude(catchValue, 5)
                }

                isChecked == false -> {
                    ex_eureka = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HSamsul.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HSamsul.setChecked(catchValue);
                    ex_samsul = keputusan_exclude(catchValue, 6)
                }

                isChecked == false -> {
                    ex_samsul = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HDebo.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HDebo.setChecked(catchValue);
                    ex_debo = keputusan_exclude(catchValue, 7)
                }

                isChecked == false -> {
                    ex_debo = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HRizal.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HRizal.setChecked(catchValue);
                    ex_jalex = keputusan_exclude(catchValue, 8)
                }

                isChecked == false -> {
                    ex_jalex = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HSativa.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HSativa.setChecked(catchValue);
                    ex_sativa = keputusan_exclude(catchValue, 9)
                }

                isChecked == false -> {
                    ex_sativa = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HKei.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HKei.setChecked(catchValue);
                    ex_kei = keputusan_exclude(catchValue, 10)
                }

                isChecked == false -> {
                    ex_kei = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HCikal.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HCikal.setChecked(catchValue);
                    ex_mabar = keputusan_exclude(catchValue, 11)
                }

                isChecked == false -> {
                    ex_mabar = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HDipo.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HDipo.setChecked(catchValue);
                    ex_ajiDipo = keputusan_exclude(catchValue, 12)
                }

                isChecked == false -> {
                    ex_ajiDipo = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HAzis.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HAzis.setChecked(catchValue);
                    ex_azis = keputusan_exclude(catchValue, 13)
                }

                isChecked == false -> {
                    ex_azis = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HJakha.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HJakha.setChecked(catchValue);
                    ex_jakha = keputusan_exclude(catchValue, 16)
                }

                isChecked == false -> {
                    ex_jakha = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HAji.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HAji.setChecked(catchValue);
                    ex_aji = keputusan_exclude(catchValue, 13)
                }

                isChecked == false -> {
                    ex_aji = 0;
                    ex_limit++
                }

                else -> null    // TERSERAH ANDA
            }
        }

        binding.HPanji.setOnCheckedChangeListener { buttonView, isChecked ->
            when {
                isChecked == true -> {
                    catchValue = cek_exclude(ex_limit)
                    binding.HPanji.setChecked(catchValue);
                    ex_panji = keputusan_exclude(catchValue, 14)
                }
                isChecked == false -> {
                    ex_panji = 0;
                    ex_limit++
                }
                else -> null    // TERSERAH ANDA
            }
        }

        // TESTER KALAU MAU LIHAT LEWAT LOG
//        binding.HArief.setOnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked == true) {
//                Log.d("CHECKBOXES", "IF is checked: $isChecked")
//            } else if (isChecked == false) {
//                Log.d("CHECKBOXES", "IF is NOT CHECKED: $isChecked")
//            }
//            Log.d("CHECKBOXES", "Cheese is checked: $isChecked")
//        }
    }

    // MAIN CODE OPERASI GACHA
    private fun codeGacha(): String {
        // HASIL AKHIR
        var finalPemenang = ""
        // HITUNG TOTAL PESERTA IKUT GACHA
        var total_winner = binding.jumlahPeloot.text.toString().toInt()
        //MASUKIN NILAI ORANG YANG GA IKUT DI GACHA
        val excludeList = listOf(
            ex_areef, ex_jae, ex_ray, ex_bags, ex_eureka,
            ex_samsul, ex_debo, ex_jalex, ex_sativa, ex_kei, ex_mabar,
            ex_ajiDipo, ex_azis, ex_jakha, ex_aji, ex_panji
        )
        // MENHITUNG JUMLAH ORANG YANG IKUT GACHA
        // BAGI YANG VALUENYA 0 AKAN DI SKIP, SEDANGKAN YANG DI EXCLUDE AKAN DI AMNIL NO ABSENNYA
        var totalExclude = 0
        for (data in excludeList){
            if(data != 0){
                totalExclude++
            }
        }

        // CEK KONDISI POSITIVE CASE DAN NEGATIVE CASE
        when {
            // NO WORRIES, ALMOST IMPOSSIBLE (KONDISI JIKA KURANG DARI 0)
//
            total_winner < 0 -> {
                ToastMessage("Ga Boleh Minus EAAAK!")
                binding.jumlahPeloot.setText("")
                izinGacha = false
            }

            // NGAPAIN LU BUKA APP INI KALAU INPUT 0, (JIKA PENGGACHA VALUENYA 0)
            total_winner == 0 -> {
                ToastMessage("Ga Boleh 0 EAAAK!")
                binding.jumlahPeloot.setText("")
                izinGacha = false
            }
            // KONDISI Gacha di atas 15 Orang(kan anak kelas cuma 16)
            total_winner > 15 -> {
                ToastMessage("MAX 15 Orang EAAAK!")
                binding.jumlahPeloot.setText("")
                izinGacha = false
            }

            // KONDISI Request Gacha dan Exclude ga sesuai
            (16 - (total_winner + totalExclude) ) <= 0 ->
            {
                ToastMessage("Ga Sesuai Mas Mba!")
                binding.jumlahPeloot.setText("")
                izinGacha = false
            }

            // POSITIVE EXECUTION
            total_winner > 0 && total_winner < 16 -> {
                var gacha = 0
                val pemenang = mutableListOf(0)     // NAMPUNG VALUE PEMENANG
                var meteran = 0                     // KONDISI STOP LOOPING
                while (meteran < total_winner) {    // MENCARI VALUE GACHA
                    gacha = (1..16).random()  // GENERATE RANDOM VALUE 1 ~ 16
                    // KONDISI KETIKA VALUE GACHA SAMA DENGAN EXCLUDE(YANG GA MAU IKUT)
                    // MAKA ENTAR DI SKIP VALUE ABSEN DARI ORANG TERSEBUT SEHINGGA TIDAK MUNCUL
                    if (gacha !in excludeList && gacha !in pemenang) {
                        pemenang.add(gacha) // MENAMPUNG SEMENTARA VALUE DARI HASIL RANDOM(ABSEN KELAS)
                        meteran++           // BUAT STOP
                    }
                }

                var batasKoma = 1;                          // MULAI DARI 1(UDAH TERLANJUR NO ABSEN DARI 1)
                var jumlahPemenang = (pemenang.size) - 1    // AMBIL MAX ORANG YANG IKUT GACHA
                                                            // MINUS 1 SUPAYA DI NAMA TERAKHIR GA ADA "KOMA"NYA
                // LOOPING BERDASARKAN JULAH DATA PEMENANG UNTUK MENGISI HASIL
                for (data in pemenang) {
                    if (data != 0) {
                        finalPemenang += namaPelakuGacha(data)  // INPUT HASIL AKHIR
                        if (batasKoma < jumlahPemenang) {       // CODE PEMBERIAN KOMA
                            finalPemenang += ", "
                        }
                        batasKoma++                             // CODE SUPAYA DI AKHIR GA ADA KOMA
                    }
                }
                izinGacha = true                                // MEMBERI IZIN BUAT LETSGOOOOOOOOO GACHA
            }

            else -> return "Null"                               // FORMALITAS
        }

        return finalPemenang                                    // MELEMPAR VALUE HASIL AKHIR
    }

    // LETS GOOOO GACHA, MOVE TO ANOTHER PAGE
    private fun letsGooooooooooo() {
        var cekForm = binding.jumlahPeloot.text.toString()
        if (cekForm == null || cekForm == "")
        {
            ToastMessage("Tolong di Isi dulu yaa!")
            binding.jumlahPeloot.setText("")
            resetDefault()
            izinGacha = false
        }
        else if (cekForm != null || cekForm != "") {
            val intent = Intent(this, hasil::class.java)        // MENUJU PAGE "hasil"
            intent.putExtra(
                "finalGacha",
                codeGacha()
            )                 // MELEMPAR NILAI KE PAGE "Hasil"
            when (izinGacha) {
                true -> {
                    startActivity(intent)       // KARNA IZIN TRUE(POSITIVE CASE) MAKA AKAN LANJUT
                }

                false -> {
                    resetDefault()              // KALAU TIDAK MAKA GA BISA LANJUT

                }
            }
        }
    }

    // RESET SETELAN PABRIK
    private fun resetDefault() {
        binding.jumlahPeloot.setText("")
        binding.HArief.setChecked(false)
        binding.HBagas.setChecked(false)
        binding.HJae.setChecked(false)
        binding.HRay.setChecked(false)
        binding.HFatma.setChecked(false)
        binding.HSamsul.setChecked(false)
        binding.HDebo.setChecked(false)
        binding.HRizal.setChecked(false)
        binding.HKei.setChecked(false)
        binding.HSativa.setChecked(false)
        binding.HCikal.setChecked(false)
        binding.HDipo.setChecked(false)
        binding.HAzis.setChecked(false)
        binding.HJakha.setChecked(false)
        binding.HAji.setChecked(false)
        binding.HPanji.setChecked(false)

    }

}


