package com.bridgelabz.employeepayroll;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Test;



public class EmployeePayrollTest {
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";
	
//	 private static void deleteFolder(File file){
//	        for (File subFile : file.listFiles()) {
//	            if(subFile.isDirectory()) {
//	                deleteFolder(subFile);
//	            } else {
//	                subFile.delete();
//	            }
//	        }
//	        file.delete();
//	    }
	
	
	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException{
		//Check File Exits
		Path homePath = Paths.get(HOME);
		assertTrue(Files.exists(homePath));
		
		//Delete File and Check File Not Exist
		Path playPath = Paths.get(HOME + "/" +PLAY_WITH_NIO);
		if(Files.exists(playPath)) {
			FileUtils.deleteFiles(playPath.toFile());
		}
		
		assertTrue(Files.notExists(playPath));

		//Create Directory
	    Files.createDirectory(playPath);
	    assertTrue(Files.exists(playPath));

	    //Create File
	    IntStream.range(1,10).forEach(cntr -> {
	    Path tempFile = Paths.get(playPath+"/temp"+cntr);
	    assertTrue(Files.notExists(tempFile));
	    try {
	    		Files.createFile(tempFile);
	        }
	    catch(IOException e) {}
	    assertTrue(Files.exists(tempFile));
	    });
	    
	    //List Files , Directories as well as Files with Extension
	    Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
	    Files.newDirectoryStream(playPath).forEach(System.out::println);
	    Files.newDirectoryStream(playPath,path -> path.toFile().isFile() && path.toString().startsWith("temp"))
	                .forEach(System.out::println);


	    }
	
	 	@Test
		public void givenDirectoryWhenWatchedListAllTheActivities() throws IOException{
			Path dir=Paths.get(HOME+"/"+PLAY_WITH_NIO);
			Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
			new Java8WatchService(dir).processEvents();
		}

	}