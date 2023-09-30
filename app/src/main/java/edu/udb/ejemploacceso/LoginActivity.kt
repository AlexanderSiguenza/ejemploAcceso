package edu.udb.ejemploacceso

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private lateinit var etUsuario: EditText
private lateinit var etContraseña: EditText
private lateinit var btnIngresar: Button

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etContraseña: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnRegistro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsuario = findViewById(R.id.etUsuario)
        etContraseña = findViewById(R.id.etContraseña)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnRegistro = findViewById(R.id.btnRegistro)

        btnIngresar.setOnClickListener {
            // Validar credenciales
            val usuario = etUsuario.text.toString()
            val contraseña = etContraseña.text.toString()

            // Iniciar sesión
            if (usuario == "admin" && contraseña == "123") {
                // Almacenar en memoria temporal
                val sharedPreferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putString("usuario", usuario)
                    putString("contraseña", contraseña)
                    apply()
                }
                val intent = Intent(this, BienvenidaActivity::class.java)
                startActivity(intent)
            } else {
                // Mostrar mensaje de error
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegistro.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

    }
}