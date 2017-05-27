package com.phani.android.test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;


public class FirstGit {

	private static ExecutorService  pool = null;
	
	public static void main(String args[]){
		System.out.println("Hello World");
		executeMultipleThreads();
		
	}
	
	
	public static void executeMultipleThreads(){
		pool = Executors.newFixedThreadPool(10);
		
		Set<ServiceRunner> calables = new HashSet<ServiceRunner>();
		
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		calables.add(new ServiceRunner());
		
		 
		List<Future<Integer>> futures;
			try {
				futures = pool.invokeAll(calables);
				for(Future<Integer> f:futures){
					System.out.println(f.get());
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}
}
