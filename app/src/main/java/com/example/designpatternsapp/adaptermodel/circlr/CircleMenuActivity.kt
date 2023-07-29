package com.example.designpatternsapp.adaptermodel.circlr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityCircleMenuBinding

class CircleMenuActivity : AppCompatActivity() {
    private lateinit var activityCircleMenuBinding: ActivityCircleMenuBinding
    private val mItemTexts by lazy {
        arrayOf(
            "安全中心",
            "特色服务",
            "投资理材",
            "转账汇款",
            "我的账户",
            "信用卡",
        )
    }

    private val mItemImages by lazy {
        intArrayOf(
            R.drawable.home_mbank_1_normal,
            R.drawable.home_mbank_2_normal,
            R.drawable.home_mbank_3_normal,
            R.drawable.home_mbank_4_normal,
            R.drawable.home_mbank_5_normal,
            R.drawable.home_mbank_6_normal
        )
    }

    private val circleMenuItems by lazy {
        listOf(
            CircleMenuItem(R.drawable.home_mbank_1_normal,"安全中心") ,
            CircleMenuItem(R.drawable.home_mbank_2_normal,"特色服务"),
            CircleMenuItem(R.drawable.home_mbank_3_normal,"投资理材"),
            CircleMenuItem(R.drawable.home_mbank_4_normal,"转账汇款"),
            CircleMenuItem(R.drawable.home_mbank_5_normal,"我的账户"),
            CircleMenuItem(R.drawable.home_mbank_6_normal,"信用卡"),

        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCircleMenuBinding = ActivityCircleMenuBinding.inflate(layoutInflater)
        setContentView(activityCircleMenuBinding.root)
        activityCircleMenuBinding.circleMenuLayout.apply {
//            setMenuItemIconsAndTexts(
//                mItemImages,
//                mItemTexts
//            )
            setOnItemClickListener { view, index ->
                Toast.makeText(
                    this@CircleMenuActivity,
                    mItemTexts[index],
                    Toast.LENGTH_SHORT
                ).show()
            }
            setAdapter(CircleMenuAdapter(circleMenuItems))
        }
    }
}