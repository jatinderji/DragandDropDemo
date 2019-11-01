package com.jatin.draganddropdemo;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        t1.setOnLongClickListener(LongClickListener);
        t2.setOnLongClickListener(LongClickListener);
        t3.setOnLongClickListener(LongClickListener);
        t4.setOnLongClickListener(LongClickListener);

        t5.setOnDragListener(DragListener);

    }

    View.OnLongClickListener LongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v)
        {
            v.setVisibility(View.INVISIBLE);
            TextView t = (TextView) v;
            ClipData data = ClipData.newPlainText("myLabel",
                    t.getText());
            View.DragShadowBuilder dragShadowBuilder =
                    new View.DragShadowBuilder(v);
            v.startDrag(data,dragShadowBuilder,v,0); // startDrag is depricated
            // use startDragandDrop
            return true;
        }
    };


    View.OnDragListener DragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event)
        {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent)
            {
             /*   case DragEvent.ACTION_DRAG_ENTERED:
                    if(view.getId()==R.id.t1)
                    {
                        t5.setText(t1.getText());
                        break;
                    }
                    else if(view.getId()==R.id.t2)
                    {
                        t5.setText(t2.getText());
                        break;
                    }
                    else if(view.getId()==R.id.t3)
                    {
                        t5.setText(t3.getText());
                        break;
                    }
                    else if(view.getId()==R.id.t4)
                    {
                        t5.setText(t4.getText());
                        break;
                    }
               */ case DragEvent.ACTION_DRAG_ENDED:
                    if(view.getId()==R.id.t1)
                    {
                        t5.setText(t1.getText());
                        break;
                    }
                    else if(view.getId()==R.id.t2)
                    {
                        t5.setText(t2.getText());
                        break;
                    }
                    else if(view.getId()==R.id.t3)
                    {
                        t5.setText(t3.getText());
                        break;
                    }
                    else if(view.getId()==R.id.t4)
                    {
                        t5.setText(t4.getText());
                        break;
                    }
            }
            return true;
        }
    };


    private void initViews()
    {
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
    }
}
