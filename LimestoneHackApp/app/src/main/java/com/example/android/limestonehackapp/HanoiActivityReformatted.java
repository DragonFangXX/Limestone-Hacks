package com.example.android.limestonehackapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.util.Log;

public class HanoiActivityReformatted extends AppCompatActivity {
    String win_string = "4321";
    int discs = 4;

    boolean selecting_src = true;
    int sel_src, sel_tgt;

    HanoiTower[] towers = new HanoiTower[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanoi_new);
        Log.d("Hanoi","Initializing");
        init();
        Log.d("Hanoi","Initialized");
    }

    protected void init() {
        HanoiBlock[] blocks = new HanoiBlock[discs];
        for(int i = 0; i<discs; i++)
            blocks[i] = new HanoiBlock(discs - 1 - i);

        towers[0] = new HanoiTower(blocks, 0, (LinearLayout) findViewById(R.id.ht_src), (LinearLayout) findViewById(R.id.hp_src));
        towers[1] = new HanoiTower(discs,  1, (LinearLayout) findViewById(R.id.ht_aux), (LinearLayout) findViewById(R.id.hp_aux));
        towers[2] = new HanoiTower(discs,  2, (LinearLayout) findViewById(R.id.ht_tgt), (LinearLayout) findViewById(R.id.hp_tgt));

        win_string = towers[0].print();
    }

    public void solve(int discs, HanoiTower src, HanoiTower tgt, HanoiTower aux) {
        if (discs > 0) {
            solve(discs - 1, src, aux, tgt);
            src.moveTopTo(tgt);
            for (HanoiTower t : towers) t.print();
            solve(discs - 1, aux, tgt, src);
        }
    }

    public HanoiTower getTower(int i) {
        if(0 <= i && i < towers.length)
            return towers[i];
        else
            return null;
    }

    public void selTower(int i) {
        Log.d("Hanoi", "Selecting Tower " + i + " for " + (selecting_src?"source":"target"));
        if(selecting_src) {
            sel_src = i;
            selecting_src = false;
        }
        else {
            if(i != sel_src) {
                sel_tgt = i;
                Log.d("Hanoi", "Shifting towers");
                towers[sel_src].moveTopTo(towers[sel_tgt]);
                if(towers[sel_tgt].print().equals(win_string))
                    win();
                selecting_src = true;
            }
        }
    }

    public void win() {
        Log.d("Hanoi", "WINNNNNNNNERRRRRRRRR!");
        System.exit(0);
    }

/**************************************************************************************************/
    protected class HanoiBlock {
        int[] hbid = {R.id.hb_1, R.id.hb_2, R.id.hb_3, R.id.hb_4};
        private int size = 0;
        private ImageView image;

        public HanoiBlock(int size) {
            this.size = size+1;
            this.image = (ImageView) findViewById(hbid[size]);
        }

        public int getSize() {
            return size;
        }
        public View getView() { return image; }
    }

/**************************************************************************************************/
    class HanoiTower {
        // Higher index is top
        private HanoiBlock[] blocks;
        private int top = 0;
        private int id = 0;

        private LinearLayout layout;
        private LinearLayout padding;

        private HanoiTower(int id, LinearLayout lt, LinearLayout lp) {
            this.id = id;
            this.layout = lt;
            this.layout.setOnClickListener(onclick);
            this.padding = lp;
        }

        public HanoiTower(HanoiBlock[] blocks, int id, LinearLayout lt, LinearLayout lp) {
            this(id, lt, lp);
            this.blocks = blocks;
            this.top = blocks.length-1;
        }

        public HanoiTower(int numblocks, int id, LinearLayout lt, LinearLayout lp) {
            this(id, lt, lp);
            this.blocks = new HanoiBlock[numblocks];
            this.top = -1;
        }

        public void moveTopTo(HanoiTower t) {
            if(0<=top) {
                layout.removeAllViews();
                if(t.addToTop(blocks[top])) {
                    blocks[top] = null;
                    if (-1 < top) top--;
                }
                refresh(false);
            }
        }

        protected boolean addToTop(HanoiBlock b) {
            if(top == -1 || blocks[top].getSize() > b.getSize()){
                blocks[++top] = b;
                refresh(true);
                return true;
            }
            else {
                return false;
            }
        }

        private void refresh(boolean clear) {
            if(clear) layout.removeAllViews();
            for(HanoiBlock b : blocks) {
                if(b!=null) {
                    layout.addView(b.getView());
                    padding.setMinimumHeight(padding.getHeight() + 20 + 10*(b.getSize()));
                }
            }
        }

        public String print() {
            String out = "";
            for(HanoiBlock b : blocks)
                out += (b!=null? b.getSize() : 0);
            return out;
        }

        //public void onclick(View v) {
        //    selTower(id);
        public View.OnClickListener onclick = new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("Hanoi", "Tower " + id + " has been selected");
                selTower(id);
            }
        };
    }
}
