package com.example.activitytest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SecondActivity","Task id is $taskId")
        setContentView(R.layout.second_layout)
//        val extraData = intent.getStringExtra("extra_data")
//        Log.d("SecondActivity","extra data is $extraData")
        val button2: Button = findViewById(R.id.button2)

        button2.setOnClickListener {
//            val intent = Intent()
//            intent.putExtra("data_return","Hello FrisActivity")
//            setResult(RESULT_OK,intent)
//            finish()
//            Activity启动模式p121
            val intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)

        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        intent.putExtra("data_return","Hello FirstActivity")
        setResult(RESULT_OK,intent)
        finish()
    }

    companion object{
        fun actionStart(context: Context,data1: String,data2:String){
            val intent = Intent(context,SecondActivity::class.java)
            intent.putExtra("param1", data1)
            intent.putExtra("param2",data2)
            context.startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity","onDestory")
    }
}
