package com.example.android.limestonehackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecursionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursion);
    }

    protected class Hanoi {
        private HanoiTower[] towers = new HanoiTower[3];

        public Hanoi(int discs) {
            for(HanoiTower t : towers) {
                t = new HanoiTower(discs);
            }

            HanoiBlock[] blocks = new HanoiBlock[4];
            for(int i = 0; i<discs; i++)
                blocks[i] = new HanoiBlock(discs-i);

            towers[0] = new HanoiTower(blocks);
        }
    }

    protected class HanoiBlock {

        private int size = 0;

        public HanoiBlock(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    protected class HanoiTower {

        // Higher index is top
        private HanoiBlock[] blocks;
        private int top = 0;

        public HanoiTower(HanoiBlock[] blocks) {
            this.blocks = blocks;
        }

        public HanoiTower(int numblocks) {
            blocks = new HanoiBlock[numblocks];
        }

        public void moveTopTo(HanoiTower t) {
            t.addToTop(blocks[top]);
            blocks[top--] = null;
        }

        protected void addToTop(HanoiBlock b) {
            blocks[++top] = b;
        }
    }
}
