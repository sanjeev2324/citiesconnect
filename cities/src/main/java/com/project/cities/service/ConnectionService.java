package com.project.cities.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {

	
    private Map<String, LinkedHashSet<String>> map = new HashMap<String, LinkedHashSet<String>>();
    private static String  ORIGIN;
    private static String  DESTINATION;
    private static boolean flag;

    public static final Logger  LOGGER = LoggerFactory.getLogger(ConnectionService.class);
    
	/** Method to find if the cities are connected
	 * @param origin
	 * @param destination
	 * @return boolean that says true or false
	 */
	public boolean isConnected(String origin, String destination, String fileName) {
		
		LinkedList<String> visited = new LinkedList<String>();
		boolean retVal = false;
		ORIGIN = origin;
		DESTINATION = destination;
		
		processTextFile(fileName);
		visited.add(ORIGIN);
		retVal = breadthFirst( visited);
		LOGGER.info("  ");
	    return retVal;
	}

	
	private void processTextFile(String fileName) {
	
		String line;
		
		try {

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/" + fileName)));
			
				while((line = bufferedReader.readLine()) != null){

					if(line.trim().length()==0)
						break;
	
					processEachLine(line);
				}
				
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void processEachLine(String line) {
		String[] cities = line.split(",");
		
		if(cities!=null && cities.length==2) {
			addEdge(cities[0].trim(),cities[1].trim());
			addEdge(cities[1].trim(),cities[0].trim());
		}
	}
	
	
	
    private void addEdge(String node1, String node2)
    {
        LinkedHashSet<String> adjacent = map.get(node1);
        if (adjacent == null)
        {
            adjacent = new LinkedHashSet();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }
 
 
    private LinkedList<String> adjacentNodes(String last)
    {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null)
        {
            return new LinkedList();
        }
        return new LinkedList<String>(adjacent);
    }

	
	
	private boolean breadthFirst(LinkedList<String> visited)
    {
        LinkedList<String> nodes = adjacentNodes(visited.getLast());
 
        for (String node : nodes)
        {
            if (visited.contains(node))
            {
                continue;
            }
            if (node.equals(DESTINATION))
            {
                visited.add(node);
                flag = true;
                visited.removeLast();
                return true;
            }
        }
 
        for (String node : nodes)
        {
            if (visited.contains(node) || node.equals(DESTINATION))
            {
                continue;
            }
            visited.addLast(node);
            breadthFirst(visited);
            visited.removeLast();
        }
        if (flag == false)
        {
        	return false;
        }
        
        return false;
 
    }
	
}
