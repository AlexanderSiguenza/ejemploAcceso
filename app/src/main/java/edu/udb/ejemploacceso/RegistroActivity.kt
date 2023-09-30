package edu.udb.ejemploacceso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegistroActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etContraseña: EditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        etUsuario = findViewById(R.id.etUsuario)
        etContraseña = findViewById(R.id.etContraseña)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            // Guardar credenciales
            val usuario = etUsuario.text.toString()
            val contraseña = etContraseña.text.toString()

            // Almacenar en memoria temporal
            val sharedPreferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("usuario", usuario)
                putString("contraseña", contraseña)
                apply()
            }

            // Ir a la pantalla de bienvenida
            val intent = Intent(this, BienvenidaActivity::class.java)
            startActivity(intent)
        }
    }
}
