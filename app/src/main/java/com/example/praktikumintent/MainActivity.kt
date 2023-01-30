package com.example.praktikumintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_move: Button
    private lateinit var btnMoveData: Button
    private lateinit var btnDial: Button
    private lateinit var btnMoveObject: Button
    private lateinit var btnMoveResult: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_move = findViewById(R.id.move)

        btn_move.setOnClickListener(this)

        btnMoveData = findViewById(R.id.btn_move_activity_with_data)
        btnMoveData.setOnClickListener(this)

        btnDial = findViewById(R.id.btn_dial_number)
        btnDial.setOnClickListener(this)

        btnMoveObject = findViewById(R.id.btn_move_activity_with_object)
        btnMoveObject.setOnClickListener(this)

        btnMoveResult = findViewById(R.id.btn_move_activity_with_result)
        btnMoveResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)


        if (intent.extras != null){
            val hasil = intent.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
            val text = "Hasil : $hasil"
            tvResult.setText(text)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.move -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Nopas")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, "17")
                startActivity(moveWithDataIntent)
            }
            R.id.btn_dial_number->{
                val phoneNumber = "081233180050"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_activity_with_object-> {
                val person = Person("Nopas","novita@gmail.com","Magetan")
                val moveWithObjectActivity = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectActivity.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectActivity)
            }
            R.id.btn_move_activity_with_result-> {
                val moveForResultIntent =
                    Intent(this@MainActivity,
                    MoveForResultActivity::class.java)
                startActivity(moveForResultIntent)
            }
        }
    }
}