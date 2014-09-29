package com.example.aademo;import android.graphics.LinearGradient;import android.graphics.Shader;import android.graphics.Shader.TileMode;import android.os.Bundle;import android.view.View;import android.view.View.OnClickListener;import android.view.animation.Animation;import android.widget.Button;import android.widget.TextView;import com.example.aademo.util.CircleProgressAnim;import com.example.aademo.widget.CircleProgressBar;import com.example.aademo.widget.CircleProgressBarlarge;public class CircleProgressActivity extends BaseActivity implements OnClickListener {	TextView tv;	// DrawView dv;	Button btn_add, btn_reduce;	CircleProgressBar mCircleProgressBar;	CircleProgressBarlarge mCircleProgressBarLarge;	float mProgressplan = 1.0f;	TextView tv_circleProgressBar;	@Override	protected void onCreate(Bundle savedInstanceState) {		super.onCreate(savedInstanceState);		setContentView(R.layout.circleprogress_main);		init();	}	private void init() {		tv = (TextView) findViewById(R.id.circleprogress_tv);		mCircleProgressBar = (CircleProgressBar) findViewById(R.id.holoCircularProgressBar1);		mCircleProgressBarLarge = (CircleProgressBarlarge) findViewById(R.id.holoCircularProgressBar);		btn_add = (Button) findViewById(R.id.circleprogress_btn_add);		btn_reduce = (Button) findViewById(R.id.circleprogress_btn_reduce);		tv_circleProgressBar=(TextView)findViewById(R.id.circleprogress_tv_progress);				btn_add.setOnClickListener(this);		btn_reduce.setOnClickListener(this);		// tv.setText("18.00%");		tv.post(new Runnable() {			@Override			public void run() {				Shader textShader = new LinearGradient(0, 0, 0, tv.getHeight(), new int[] { getColor(R.color.circleprogress_tv_color_top), getColor(R.color.circleprogress_tv_color_bottom) }, new float[] { 0, 1 }, TileMode.MIRROR);				tv.getPaint().setShader(textShader);			}		});		mCircleProgressBar.setProgress(mProgressplan);		mCircleProgressBarLarge.setProgress(mProgressplan);		// tv_circleProgressBar.setText(Math.floor(mProgressplan*100) + "%");				doProgressAnim(0.95f);	}	public void doProgressAnim(float progressplan) {		mCircleProgressBarLarge.clearAnimation();		CircleProgressAnim anim = new CircleProgressAnim(mCircleProgressBarLarge,tv_circleProgressBar);		anim.setDuration(2000);		anim.setFillAfter(true);		mCircleProgressBarLarge.setProgress(progressplan);		anim.setProgress(progressplan);		anim.start();	}	@Override	public void onClick(View v) {		int controlID = v.getId();		if (controlID == R.id.circleprogress_btn_add) {			mProgressplan += 0.05f;			mCircleProgressBar.setProgress(mProgressplan);			mCircleProgressBarLarge.setProgress(mProgressplan);		} else if (controlID == R.id.circleprogress_btn_reduce) {			mProgressplan -= 0.05f;			mCircleProgressBar.setProgress(mProgressplan);			mCircleProgressBarLarge.setProgress(mProgressplan);		}	}}