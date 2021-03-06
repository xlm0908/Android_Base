/*
 * Copyright (C) 2013 Peng fei Pan <sky@xiaopan.me>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android_base.util.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.android_base.util.app.GetPageTitleListener;

import java.util.ArrayList;
import java.util.List;


public class ViewListPagerAdapter extends PagerAdapter {
	private List<View> views;
	private GetPageTitleListener getPageTitleListener;
	
	public ViewListPagerAdapter(List<View> views){
		this.views = views;
	}
	
	public ViewListPagerAdapter(View... views){
		this.views = new ArrayList<View>(views.length);
		for(View view : views){
			this.views.add(view);
		}
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));
	}

	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position), 0);
		return views.get(position);
	}

	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		if(getPageTitleListener != null){
			return getPageTitleListener.onGetPageTitle(position);
		}else{
			return super.getPageTitle(position);
		}
	}

	public List<View> getViews() {
		return views;
	}

	public void setViews(List<View> views) {
		this.views = views;
	}
	
	public void setGetPageTitleListener(GetPageTitleListener getPageTitleListener) {
		this.getPageTitleListener = getPageTitleListener;
	}
}
