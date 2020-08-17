package sim.coder.ithoughtitwaslove

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import com.muddzdev.styleabletoast.StyleableToast






class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        StyleableToast.Builder(this)
            .text("نقرأ لنعرف أنّنا لسنا وحدنا")
            .length(1)
            .iconEnd(R.drawable.book)
            .textColor(Color.BLACK)
            .textBold()
            .backgroundColor(Color.LTGRAY)
            .show()




        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)





        MobileAds.initialize(this) {}
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-5329195808649014/4912455995"
        mInterstitialAd.loadAd(
            AdRequest.Builder()
                .build())

        mInterstitialAd.adListener= object : AdListener(){

            override fun onAdLoaded() {
                mInterstitialAd.show()
                super.onAdLoaded()
            }
        }





    }

    fun Read(view: View) {

        var i = Intent(Intent(this,BookPage::class.java))
        startActivity(i)

        StyleableToast.Builder(this)
            .text("البيت دون كتب كالجسد بلا روح")
            .iconEnd(R.drawable.boo)
            .length(3)
            .backgroundColor(Color.BLUE)
            .textColor(Color.WHITE)
            .textBold()
            .show()



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater= menuInflater
        inflater.inflate(R.menu.menu,menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.share->{
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=sim.coder.ithoughtitwaslove")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }


        }


        return super.onOptionsItemSelected(item)
    }
}
