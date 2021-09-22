package ge.nlatsabidze.thirdtask

import android.os.*
import android.widget.*
import android.text.TextUtils
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import ge.nlatsabidze.thirdtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val email = binding.email
        val userName = binding.userName
        val firstName = binding.firstName
        val lastName = binding.lastName
        val age = binding.age

        val enteredEmail = email.text
        val enteredUserName = userName.text
        val enteredFirstName = firstName.text
        val enteredLastName = lastName.text
        val enteredAge = age.text

        val saveButton = binding.saveButton
        val clearButton = binding.clearButton

        val checkEmail = checkEmailCorrectness(enteredEmail.toString())

        saveButton.setOnClickListener {
            if (enteredEmail.length != 0 && !checkEmail && enteredUserName.length >= 10 &&
                    enteredFirstName.length != 0 && enteredLastName.length != 0 &&
                    enteredAge.length != 0 && enteredAge.toString().toInt() > 0) {
                Toast.makeText(applicationContext, "Successfully saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Check that everything is correct!", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnLongClickListener {
            enteredEmail.clear()
            enteredUserName.clear()
            enteredFirstName.clear()
            enteredLastName.clear()
            enteredAge.clear()
            true
        }
    }

    private fun checkEmailCorrectness(email: String):Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}