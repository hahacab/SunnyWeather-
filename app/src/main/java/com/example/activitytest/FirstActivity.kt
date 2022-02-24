package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
//第三章 Activity p83
class FirstActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity","Task id is$taskId")
        setContentView(R.layout.first_layout)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
//            val intent = Intent(this,SecondActivity::class.java)
//            startActivity(intent)
//            val intent = Intent(this,SecondActivity::class.java)
//            startActivityForResult(intent,1)

//            Toast.makeText(this,"You clicked Button 1",Toast.LENGTH_SHORT).show()
//           val intent = Intent("com.example.activitytest.ACTION_START")
//            intent.addCategory("com.example.activitytest.MY_CATEGORY")
//            val webpage: Uri = Uri.parse("https://www.baidu.com")
//            val intent = Intent(Intent.ACTION_VIEW, webpage)

//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")

//            val data = "Hello SecondActivity"
//            val intent = Intent(this,SecondActivity:: class.java)
//            intent.putExtra("extra_data",data)
//            startActivity(intent)

            SecondActivity.actionStart(this, "data1","data2")

        }
//        val button1: Button = findViewById(R.id.button1)
//        findViewById()方法获取布局中定义的元素
//        setOnClickListener 注册监听器

        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item -> Toast.makeText(this,"You clicked Add",
            Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this,"You clicked Remove",
                Toast.LENGTH_SHORT).show()
        }
        return  true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 ->if (resultCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity","return data is $returnedData")
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstACtivity","onReStart")
    }
}
