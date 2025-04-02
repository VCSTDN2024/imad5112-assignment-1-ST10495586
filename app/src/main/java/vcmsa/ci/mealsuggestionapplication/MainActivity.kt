package vcmsa.ci.mealsuggestionapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

// Declare  UI Elements
    private var Display: TextView? = null
    private var Insert: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        Insert = findViewById(R.id.Insert)
        Display = findViewById(R.id.Display)
// Initialize UI Elements
        val BtnGenerate = findViewById<Button>(R.id.BtnGenerate)
        val BtnClear = findViewById<Button>(R.id.BtnClear)
        val BtnExit = findViewById<Button>(R.id.BtnExit)

// This Button is to clear any user input
        BtnClear.setOnClickListener {
            Insert?.text?.clear()
            Display?.text = ""
        }
// This button is to exit the application
        BtnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
//This button is to Generate meals when user has places an input
        BtnGenerate.setOnClickListener {
            generate()
        }


    }

    // isNotEmpty function to ensure that the user does not leave the EditText empty

    private fun isNotEmpty(): Boolean {
        var b = true
        val timeText = Insert?.text.toString().trim()
        if (timeText.isEmpty()) {
            Insert?.error = "Input required!"
            b = false

        } else {
            val time = timeText.toIntOrNull()
            if (time == null) {
                Insert?.error = "Invalid input. Please enter a valid number."
                b = false
            }
        }
        return b
    }


// This are the meals that display when an a user enters an input
    private fun generate() {
        if (isNotEmpty()) {
            val timeText = Insert?.text.toString().trim()
            val time = timeText.toIntOrNull()
            if (time != null) {
                when (time) {

                    in 500..959 -> Display?.text = "Breakfast\n Bacon and Eggs"
                    in 1000..1159 -> Display?.text = "Mid Morning \n Waffles and Syrup"
                    in 1200..1459 -> Display?.text = "Lunch \n Baked Chicken fingers"
                    in 1500..1759 -> Display?.text = "Mid Lunch \n Burrito Bowls"
                    in 1800..2059 -> Display?.text = "Dinner \n  Cheesy Beef Pasta"
                    in 2100..2159 -> Display?.text = "After Dinner\n Cottage Pie"

                    else -> {
                        Display?.text = "no meals"
                    }
                }
            }
        }
    }

}
