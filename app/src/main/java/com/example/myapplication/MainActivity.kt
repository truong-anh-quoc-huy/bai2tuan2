package com.example.librarymanager

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    private lateinit var edtStaffName: EditText
    private lateinit var lvBooks: ListView
    private lateinit var edtNewBook: EditText
    private lateinit var btnAddBook: Button
    private lateinit var bookAdapter: ArrayAdapter<String>
    private val bookList = mutableListOf("Sách 01", "Sách 02")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ View
        edtStaffName = findViewById(R.id.edtStaffName)
        lvBooks = findViewById(R.id.lvBooks)
        edtNewBook = findViewById(R.id.edtNewBook)
        btnAddBook = findViewById(R.id.btnAddBook)

        // Tạo Adapter cho ListView
        bookAdapter = ArrayAdapter(this, R.layout.layout_list, R.id.tvLayout, bookList)
        lvBooks.adapter = bookAdapter

        // Xử lý sự kiện nút "Thêm"
        btnAddBook.setOnClickListener {
            val newBook = edtNewBook.text.toString().trim()
            if (newBook.isNotEmpty()) {
                bookList.add(newBook) // Thêm sách vào danh sách
                bookAdapter.notifyDataSetChanged() // Cập nhật ListView
                edtNewBook.text.clear() // Xóa nội dung nhập
                Toast.makeText(this, "Đã thêm sách: $newBook", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Vui lòng nhập tên sách", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
