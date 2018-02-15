package search;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import mazes.Cell;
import mazes.Maze;
import mazes.MazeGenerator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SearcherTest {
	@Rule
	public Timeout globalTimeout = new Timeout(500L, TimeUnit.MILLISECONDS);

	private Maze maze;
	private Maze maze1;

	@Before
	public void before() {
		maze = new MazeGenerator(3, 3, 2).generateDFS();
		maze1=new MazeGenerator(4,4,2).generateDFS();
		/* maze should now be:
		#0#1#2#
		0  S  0
		# # # #
		1     1
		# ### #
		2  G  2
		#0#1#2#
		*/
	}
	
	@Test
	public void testIsValidSolution0() {
		List<Cell> solution = new ArrayList<Cell>();
		Searcher<Cell> s = new RecursiveDepthFirstSearcher<Cell>(maze1);
		solution.add(new Cell(1, 1));
		solution.add(new Cell(1, 0));
		solution.add(new Cell(2, 0));
		solution.add(new Cell(2, 1));
		solution.add(new Cell(3, 1));
		
		assertTrue(s.isValidSolution(solution));
	}
	
	@Test
	public void testIsValidSolution() {
		List<Cell> solution = new ArrayList<Cell>();
		Searcher<Cell> s = new RecursiveDepthFirstSearcher<Cell>(maze);
		solution.add(new Cell(1, 0));
		solution.add(new Cell(0, 0));
		solution.add(new Cell(0, 1));
		solution.add(new Cell(0, 2));
		solution.add(new Cell(1, 2));
		assertTrue(s.isValidSolution(solution));
	}

	@Test
	public void testSolutionStartsNotAtInitialState() {
		List<Cell> solution = new ArrayList<Cell>();
		Searcher<Cell> s = new RecursiveDepthFirstSearcher<Cell>(maze);
		solution.add(new Cell(0, 0));
		solution.add(new Cell(0, 1));
		solution.add(new Cell(0, 2));
		solution.add(new Cell(1, 2));
		assertFalse(s.isValidSolution(solution));
	}

	@Test
	public void testSolutionDoesNotReachGoal() {
		List<Cell> solution = new ArrayList<Cell>();
		Searcher<Cell> s = new RecursiveDepthFirstSearcher<Cell>(maze);
		solution.add(new Cell(1, 0));
		solution.add(new Cell(0, 0));
		solution.add(new Cell(0, 1));
		solution.add(new Cell(0, 2));
		assertFalse(s.isValidSolution(solution));
	}

	@Test
	public void testSolutionSkipsState() {
		List<Cell> solution = new ArrayList<Cell>();
		Searcher<Cell> s = new RecursiveDepthFirstSearcher<Cell>(maze);
		solution.add(new Cell(1, 0));
		solution.add(new Cell(0, 0));
		solution.add(new Cell(0, 2));
		solution.add(new Cell(1, 2));
		assertFalse(s.isValidSolution(solution));
	}

	@Test
	public void testSolutionNotAdjancentStates() {
		List<Cell> solution = new ArrayList<Cell>();
		Searcher<Cell> s = new RecursiveDepthFirstSearcher<Cell>(maze);
		solution.add(new Cell(1, 0));
		solution.add(new Cell(1, 1));
		solution.add(new Cell(1, 2));
		assertFalse(s.isValidSolution(solution));
	}
	
	/*  @Test
	 public void testDFS() {
		StackBasedDepthFirstSearcher<Cell> a=new StackBasedDepthFirstSearcher<Cell>(maze);
		List<Cell> b=a.findSolution();
		for(int i=0;i<5;i++){
			System.out.println(b.get(i));
		}
	}
	*/
	 /*@Test
	public void testBFS() {
		QueueBasedBreadthFirstSearcher<Cell> a=new QueueBasedBreadthFirstSearcher<Cell>(maze);
		List<Cell> b=a.findSolution();
		
		for(int i=0;i<9;i++){
		System.out.println(b.get(i));
		}
	}
	  */ /*@Test
	 public void testDFS1() {
		StackBasedDepthFirstSearcher<Cell> a=new StackBasedDepthFirstSearcher<Cell>(maze1);
		List<Cell> b=a.findSolution();
		for(int i=0;i<20;i++){
		System.out.println(b.get(i));
		}
	}*/
	
	 @Test
	public void testBFS2() {
		QueueBasedBreadthFirstSearcher<Cell> a=new QueueBasedBreadthFirstSearcher<Cell>(maze1);
		List<Cell> b=a.findSolution();
		
		for(int i=0;i<5;i++){
		System.out.println(b.get(i));
		}
	}

}
