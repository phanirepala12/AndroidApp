package com.phani.android.main;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.phani.android.dto.StorageDTO;

import java.util.List;


public class FirstGit {


	private static final Logger log = Logger.getLogger(FirstGit.class.getName());
	
	private ExecutorService  pool = null;
	
	
	
	long startTime;
	
	public static void main(String args[]){
		new FirstGit().executeMultipleThreads(Integer.parseInt(args[0]));
		
	}
	
	
	public void executeMultipleThreads(int numberOfTrdaes){
		
		int trades = numberOfTrdaes /100;
		pool = Executors.newFixedThreadPool(100);
		
		Set<ServiceRunner> calables = new HashSet<ServiceRunner>();
		
		
		for(int i =1; i<= 100 ;i++){
			calables.add(new ServiceRunner(trades));
		}
		/*calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));
		calables.add(new ServiceRunner(trades));*/
		
		List<Future<List<StorageDTO>>> futures;
			try {
				
				System.out.println("startTime:"+startTime);
				
				futures = pool.invokeAll(calables);
				startTime = System.currentTimeMillis();
				
				for(Future<List<StorageDTO>> f:futures){
					for(StorageDTO ls: f.get()){
						log.info(ls.getFirstName());
					}
				}
				
				pool.shutdown();
				
				System.out.println("End Time:"+ (System.currentTimeMillis()-startTime));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}
}
