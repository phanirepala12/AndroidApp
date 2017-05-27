package com.phani.android.test;

import java.util.concurrent.Callable;

public class ServiceRunner implements Callable<Integer> {

	private static int i =0;
	@Override
	public Integer call() throws Exception {
		
		
		return ++i;
	}

}
