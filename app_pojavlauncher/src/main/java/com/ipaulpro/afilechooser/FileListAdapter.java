/*
 * Copyright (C) 2012 Paul Burke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ipaulpro.afilechooser;

import android.content.*;
import android.content.res.ColorStateList;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.*;
import net.kdt.pojavlaunch.*;

/**
 * List adapter for Files.
 * 
 * @version 2013-12-11
 * @author paulburke (ipaulpro)
 *
 * @addDate 2018-08-08
 * @addToMyProject khanhduy032
 */
public class FileListAdapter extends BaseAdapter {

    private final static int ICON_FOLDER = R.drawable.ic_folder;
    private final static int ICON_FILE = R.drawable.ic_file;

    // Amethyst look
    private final static int TEXT_COLOR = 0xFFEDE7FF;
    private final static int ICON_COLOR = 0xFF9D7BFF;

    private final LayoutInflater mInflater;

    private List<File> mData = new ArrayList<File>();

    public FileListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void add(File file) {
        mData.add(file);
        notifyDataSetChanged();
    }

    public void remove(File file) {
        mData.remove(file);
        notifyDataSetChanged();
    }

    public void insert(File file, int index) {
        mData.add(index, file);
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    @Override
    public File getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public List<File> getListItems() {
        return mData;
    }

    /**
     * Set the list items without notifying on the clear. This prevents loss of
     * scroll position.
     *
     * @param data
     */
    public void setListItems(List<File> data) {
        mData = data;
        notifyDataSetChanged();
    }

    private static int dp(View v, int value) {
        return Math.round(value * v.getResources().getDisplayMetrics().density);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);

            // Style the row once, when it is first created
            TextView styled = (TextView) row;
            styled.setBackgroundResource(R.drawable.amethyst_bg_file_row);
            styled.setTextColor(TEXT_COLOR);
            styled.setTextSize(15);
            styled.setMinHeight(dp(row, 52));
            styled.setPadding(dp(row, 20), dp(row, 10), dp(row, 20), dp(row, 10));
            styled.setCompoundDrawablePadding(dp(row, 12));
            styled.setCompoundDrawableTintList(ColorStateList.valueOf(ICON_COLOR));
        }

        TextView view = (TextView) row;

        // Get the file at the current position
        final File file = getItem(position);

        // Set the TextView as the file name
        view.setText(file.getName());

        // If the item is not a directory, use the file icon
        int icon = file.isDirectory() ? ICON_FOLDER : ICON_FILE;
        view.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        return row;
    }

}
