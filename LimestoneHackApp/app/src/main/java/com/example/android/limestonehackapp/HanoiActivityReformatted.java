package com.example.android.limestonehackapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
        init();
    }

    protected void init() {
        HanoiBlock[] blocks = new HanoiBlock[discs];
        for(int i = 0; i<discs; i++)
            blocks[i] = new HanoiBlock(i+1);

        towers[0] = new HanoiTower(blocks, 0, (LinearLayout) findViewById(R.id.ht_src));
        towers[1] = new HanoiTower(discs,  1, (LinearLayout) findViewById(R.id.ht_aux));
        towers[2] = new HanoiTower(discs,  2, (LinearLayout) findViewById(R.id.ht_tgt));

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
        if(selecting_src) {
            sel_src = i;
            selecting_src = false;
        }
        else {
            if(i != sel_src) {
                sel_tgt = i;
                towers[sel_src].moveTopTo(towers[sel_tgt]);
                if(towers[sel_tgt].print().equals(win_string))
                    win();
                selecting_src = true;
            }
        }
    }

    public void win() {
        System.exit(0);
    }

/**************************************************************************************************/
    protected class HanoiBlock {
        int[] hbid = {R.id.hb_1, R.id.hb_2, R.id.hb_3, R.id.hb_4};
        private int size = 0;
        private ImageView image;

        public HanoiBlock(int size) {
            this.size = size;
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

        private HanoiTower(int id, LinearLayout lt) {
            this.id = id;
            this.layout = lt;
        }

        public HanoiTower(HanoiBlock[] blocks, int id, LinearLayout lt) {
            this(id, lt);
            this.blocks = blocks;
            this.top = blocks.length-1;
        }

        public HanoiTower(int numblocks, int id, LinearLayout lt) {
            this(id, lt);
            this.blocks = new HanoiBlock[numblocks];
            this.top = -1;
        }

        public void moveTopTo(HanoiTower t) {
            if(0<=top) {
                t.addToTop(blocks[top]);
                blocks[top] = null;
                if(-1 < top) top--;
                refresh();
            }
        }

        protected void addToTop(HanoiBlock b) {
            blocks[++top] = b;
            refresh();
        }

        private void refresh() {
            layout.removeAllViews();
            for(HanoiBlock b : blocks) {
                layout.addView(b.getView());
            }
        }

        public String print() {
            String out = "";
            for(HanoiBlock b : blocks)
                out += (b!=null? b.getSize() : 0);
            return out;
        }

        public void onclick() {
            selTower(id);
        };
    }
}
