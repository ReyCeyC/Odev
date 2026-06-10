import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.editTextUsername)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val loginBtn = findViewById<Button>(R.id.buttonLogin)

        loginBtn.setOnClickListener {

            val user = username.text.toString()
            val pass = password.text.toString()

            if (user == "admin" && pass == "1234") {

                Toast.makeText(this, "Giriş başarılı", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {
                Toast.makeText(this, "Hatalı giriş", Toast.LENGTH_SHORT).show()
            }
        }
    }
}