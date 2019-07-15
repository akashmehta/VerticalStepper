package com.aakash.verticalstepper

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.animation.TranslateAnimation
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                R.id.btnFirst -> {
                    tvFirst.text = ""
                    tvSecond.text = ""
                    tvThird.text = ""
                    val toX = rlSecond.x
                    val toY = rlSecond.y
                    val fromX = rlFirst.x
                    val fromY = rlFirst.y
                    rlSecond.setSolidBg()
                    ivFirstTick.setVisible()

                    tvRealFirst.setGone()
                    val animation = TranslateAnimation(fromX, toX, -toY, fromY)
                    animation.duration = 1000
                    tvRealSecond.startAnimation(animation)

                    tvRealThird.startAnimation(animation)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        window.decorView.post {
            val viewTreeObserver = window.decorView.viewTreeObserver
            viewTreeObserver.addOnDrawListener {
                btnFirst.setOnClickListener(this)
                setLocation(tvFirst, tvRealFirst)
                setLocation(tvSecond, tvRealSecond)
                setLocation(tvThird, tvRealThird)
            }
        }

    }

    private fun setLocation(source: TextView, dest: TextView) {
        val loc = IntArray(2)
        source.getLocationInWindow(loc)
        dest.x = loc[0].toFloat() - 5
        dest.y = loc[1].toFloat() - 162
    }

    private fun RelativeLayout.setSolidBg() {
        this.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.bg_white_solid_circle)
    }

    private fun RelativeLayout.setOutlineBg() {
        this.background = ContextCompat.getDrawable(this@MainActivity, R.drawable.bg_white_outline_circle)
    }

    fun View.setVisibility(isShow: Boolean) {
        this.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    fun View.setVisible() {
        this.visibility = View.VISIBLE
    }

    fun View.setGone() {
        this.visibility = View.GONE
    }

    fun View.setInvisible() {
        this.visibility = View.INVISIBLE
    }
}