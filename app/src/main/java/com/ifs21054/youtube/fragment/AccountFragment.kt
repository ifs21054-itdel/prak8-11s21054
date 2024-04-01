package com.ifs21054.youtube.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ifs21054.youtube.R

class AccountFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // Mendapatkan referensi TextView untuk email dan nomor telepon
        val emailTextView = view.findViewById<TextView>(R.id.email)
        val phoneTextView = view.findViewById<TextView>(R.id.noHP)

        // Menambahkan OnClickListener untuk email
        emailTextView.setOnClickListener {
            val email = emailTextView.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:$email")
            startActivity(intent)
        }

        // Menambahkan OnClickListener untuk nomor telepon
        phoneTextView.setOnClickListener {
            val phone = phoneTextView.text.toString()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phone")
            startActivity(intent)
        }

        return view
    }
}
