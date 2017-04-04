package com.example.android.BluetoothChat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class myPaintView extends SurfaceView implements Callback,Runnable {

	private SurfaceHolder sfh;
	private Canvas canvas;
	private Paint p;
	private Paint pl;
	private mOnFingerListener myFingerEven;
	public static Car car = new Car(0,0);
	public static int line[] = new int[2048];
	
	public static int count = 0 ;

	private Boolean B = true;
	private int x = 20, y = 20;
	private String str = new String("hey,girl");
	private int max_x, max_y;

	public mOnFingerListener getMyFingerEven() {
		return myFingerEven;
	}

	public void setMyFingerEven(mOnFingerListener myFingerEven) {
		this.myFingerEven = myFingerEven;
	}

	
	public myPaintView(Context context) {
		super(context);
		p = new Paint();
		p.setAntiAlias(true);
		sfh = this.getHolder();
		sfh.addCallback(this);
		setFocusable(true);
	}

	public myPaintView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public myPaintView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		if (holder.isCreating()) {
			y = this.getMeasuredHeight() / 2;
			x = this.getMeasuredWidth() / 2;
			pl = new Paint();
			pl.setColor(Color.GREEN);
			max_x = x * 2;
			max_y = y * 2;

			Log.d("x", "" + x);
			Log.d("y", "" + y);

			car.setPosition(x, y);
			
			B = true;
			draw();
			Log.d("thread_start", "start");
		}
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_DOWN
				|| event.getAction() == MotionEvent.ACTION_MOVE) {

		}

		return true;
	}
	
	public void init_line(){
		this.line = new int[2048];
		this.line[0]=max_x/2;
		this.line[1]=max_y/2;
		this.count = 2;
	}

	void draw() {

		try {

			canvas = sfh.lockCanvas();
			if (canvas != null) {
				canvas.drawColor(Color.WHITE);
				// canvas.drawRect(new Rect(20,max_y - 40,x - (tmp_countX-2) *
				// tmpR,y - (tmp_countY-2) * tmpR)
				// ,p);
				// int tmp1,tmp2,tmp_countX=6,tmp_countY=6;
				// int tmpR = 20;
				// draw four Rects,color in black
				// p.setColor(Color.GREEN);
				// for (tmp1 = 0; tmp1 < 4; tmp1++) {
				// for ( tmp2 = 0; tmp2 < 4; tmp2++) {
				// canvas.drawRect(new Rect(x - tmp_countX * tmpR,y - tmp_countY
				// * tmpR,x - (tmp_countX-2) * tmpR,y - (tmp_countY-2) * tmpR)
				// ,p);
				// tmp_countX -= 3;
				// }
				// tmp_countX = 6;
				// tmp_countY -= 3;
				// }
				p.setColor(Color.BLUE);
				Log.i("car?","flashing");
				drawcar(car.get_x(),car.get_y(),0,p);
			}

		} catch (Exception e) {
			Log.v("Bug", "This is a bug on paintview.");

		} finally {
			if (canvas != null) {
				sfh.unlockCanvasAndPost(canvas);
			}

		}

	}


	public void run() {
		// TODO Auto-generated method stub

		while (B) {

			draw();
			Log.e("!!!!","run!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void drawcar(int x, int y,double rad,Paint p){
		Log.e("!!!!","drawn!");
		p.setColor(Color.BLUE);
		Path path1 = new Path();
		path1.moveTo(x, y-10);// 此点为多边形的起点
		path1.lineTo(x-10, y+10);
		path1.lineTo(x+10, y+10);
		path1.close(); // 使这些点构成封闭的多边形
		canvas.drawPath(path1, p);
		
		p.setColor(Color.RED);
		canvas.drawLine(x, y-10, x, y-15, p);
	}
}
