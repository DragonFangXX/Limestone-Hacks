package com.example.android.limestonehackapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class HanoiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursion);
    }

/**************************************************************************************************/
    public class Hanoi {
        private HanoiTower[] towers = new HanoiTower[3];
        private int sel_src, sel_tgt, sel_aux;

        public Hanoi(int discs) {
            HanoiBlock[] blocks = new HanoiBlock[discs];
            for(int i = 0; i<discs; i++)
                blocks[i] = new HanoiBlock(i+1);

            towers[0] = new HanoiTower(blocks, (LinearLayout) findViewById(R.id.ht_src));
            towers[1] = new HanoiTower(discs,  (LinearLayout) findViewById(R.id.ht_aux));
            towers[2] = new HanoiTower(discs,  (LinearLayout) findViewById(R.id.ht_tgt));
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

/**************************************************************************************************/
        protected class HanoiBlock {

            private int size = 0;

            public HanoiBlock(int size) {
                this.size = size;
            }

            public int getSize() {
                return size;
            }
        }

/**************************************************************************************************/
        protected class HanoiTower {

            // Higher index is top
            private HanoiBlock[] blocks;
            private int top = 0;

            private LinearLayout layout;

            public HanoiTower(HanoiBlock[] blocks, LinearLayout lt) {
                this.layout = lt;
                this.blocks = blocks;
                this.top = blocks.length-1;
            }

            public HanoiTower(int numblocks, LinearLayout lt) {
                this.layout = lt;
                this.blocks = new HanoiBlock[numblocks];
                this.top = -1;
            }

            public void moveTopTo(HanoiTower t) {
                t.addToTop(blocks[top]);
                blocks[top] = null;
                if(-1 < top) top--;
            }

            protected void addToTop(HanoiBlock b) {
                blocks[++top] = b;
            }

            public void print() {
                String out = "";
                for(HanoiBlock b : blocks)
                    out += (b!=null? b.getSize() : 0);
            }
        }
    }
}
