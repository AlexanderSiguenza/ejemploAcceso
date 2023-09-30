package edu.udb.ejemploacceso

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class BienvenidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        // Obtener credenciales de memoria temporal
        val sharedPreferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        val usuario = sharedPreferences.getString("usuario", "")
        val contraseña = sharedPreferences.getString("contraseña", "")

        // Mostrar mensaje de bienvenida
        Toast.makeText(this, "Bienvenido, $usuario", Toast.LENGTH_SHORT).show()

    }
}