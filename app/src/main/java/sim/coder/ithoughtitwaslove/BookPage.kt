package sim.coder.ithoughtitwaslove

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_book_page.*

class BookPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_page)


        var sharedPreferences= getSharedPreferences("BookLove", Context.MODE_PRIVATE)

        var edit= sharedPreferences.edit()
        var number=sharedPreferences.getInt("numPage",0)


        pdf.fromAsset("love.pdf")
            .defaultPage(number)
            .password(null)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .enableAnnotationRendering(true)
            .onPageChange { page, pageCount ->
                edit.putInt("numPage",page)
                  edit.commit()
            }
            .load()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_book,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()

        return super.onOptionsItemSelected(item)
    }


}
