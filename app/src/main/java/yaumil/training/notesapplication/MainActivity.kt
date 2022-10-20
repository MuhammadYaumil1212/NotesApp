package yaumil.training.notesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import yaumil.training.notesapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val user: MutableMap<String, Any> = HashMap()
        user["first"] = "Muhammad"
        user["last"] = "Yaumil Ramadhani"
        user["born"] = 2001

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("TAB","DocumentSnapshot add with ID : " + documentReference.id) }
            .addOnFailureListener { e -> Log.w("TAB","Error adding document",e) }

    }
}