using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Linq;

public class A_Star_PathFinding : MonoBehaviour
{


	private static Tile start;
	private static Tile finish;

	
	private static int[,] collisionMatrix = new int[56, 56];

	// Start is called before the first frame update
	void Start()
    {


		collisionMatrix = LoadingBitmap.getCollisionMatrix();
		start = new Tile();
		finish = new Tile();



		
	}

    // Update is called once per frame
    void Update()
    {
        
    }


    public static Stack<Tile> findPath(Vector2 Start,Vector2 Target)
    {
		
		Stack<Tile> path = new Stack<Tile>();
		start.position = Start;
		finish.position = Target;

		start.SetDistance(finish.position);

		var activeTiles = new List<Tile>();
		activeTiles.Add(start);
		var visitedTiles = new List<Tile>();

		//This is where we created the map from our previous step etc. 

		while (activeTiles.Any())
			{
				Tile checkTile = activeTiles.OrderBy(x => x.CostDistance).First();

				if (checkTile.position==finish.position)
				{
				
					//Debug.Log("We are at the destination!");

				//checkTile = checkTile.Parent;//WE GET RID OF THE FIRST ELEMENT, WHICH IS BASICALY OUR POSITION;
				path.Push(new Tile());

                while (checkTile != null)
                {

					path.Push(checkTile);

					checkTile = checkTile.Parent;
                }
				return path;
				
				/*
				 * Vector2 convertedToMap;
				//We can actually loop through the parents of each tile to find our exact path which we will show shortly. 

				//display path

				
					//We found the destination and we can be sure (Because the the OrderBy above)
					//That it's the most low cost option. 
					var tile = checkTile;
					Debug.Log("Retracing steps backwards...");
					while (true)
					{
						Debug.Log(tile.position);

					//desen
					 convertedToMap.x = (float)0.5 * (tile.position.x + tile.position.y) - 56 / 2;
					 convertedToMap.y = (float)0.25 * (tile.position.x - tile.position.y);

					RaycastHit2D hit = Physics2D.Raycast(new Vector2(convertedToMap.x + (float)0.125, convertedToMap.y), convertedToMap);

					GameObject lastGameobject;
					if (hit.collider != null)
					{
						// Debug.Log("am lovit");
						lastGameobject = hit.collider.gameObject;
						lastGameobject.GetComponent<SpriteRenderer>().color = new Color32(150, 150, 150, 255);

					}
					
					tile = tile.Parent;
						if (tile == null)
						{
							return null;
						}
					}


				*/
			}

			visitedTiles.Add(checkTile);
				activeTiles.Remove(checkTile);

				var walkableTiles = GetWalkableTiles(collisionMatrix, checkTile, finish);

				foreach (var walkableTile in walkableTiles)
				{
					//We have already visited this tile so we don't need to do so again!
					if (visitedTiles.Any(x => x.position==walkableTile.position))
						continue;

					//It's already in the active list, but that's OK, maybe this new tile has a better value (e.g. We might zigzag earlier but this is now straighter). 
					if (activeTiles.Any(x => x.position==walkableTile.position))
					{
						var existingTile = activeTiles.First(x => x.position == walkableTile.position);
						if (existingTile.CostDistance > checkTile.CostDistance)
						{
							activeTiles.Remove(existingTile);
							activeTiles.Add(walkableTile);
						}
					}
					else
					{
						//We've never seen this tile before so add it to the list. 
						activeTiles.Add(walkableTile);
					}
				}
			}

			Debug.Log("No Path Found!");

		return null;

		}

	

	private static  List<Tile> GetWalkableTiles(int[,] map, Tile currentTile, Tile targetTile)
	{
		var possibleTiles = new List<Tile>()
	{
		new Tile { position = new Vector2(currentTile.position.x,currentTile.position.y-1), Parent = currentTile, Cost = currentTile.Cost + 1},
		new Tile {position = new Vector2(currentTile.position.x,currentTile.position.y+1), Parent = currentTile, Cost = currentTile.Cost + 1},
		new Tile {position = new Vector2(currentTile.position.x-1,currentTile.position.y), Parent = currentTile, Cost = currentTile.Cost + 1 },
		new Tile { position = new Vector2(currentTile.position.x+1,currentTile.position.y), Parent = currentTile, Cost = currentTile.Cost + 1 },

		new Tile { position = new Vector2(currentTile.position.x-1,currentTile.position.y+1), Parent = currentTile, Cost = currentTile.Cost + 1},
		new Tile {position = new Vector2(currentTile.position.x-1,currentTile.position.y-1), Parent = currentTile, Cost = currentTile.Cost + 1},
		new Tile {position = new Vector2(currentTile.position.x+1,currentTile.position.y+1), Parent = currentTile, Cost = currentTile.Cost + 1 },
		new Tile { position = new Vector2(currentTile.position.x+1,currentTile.position.y-1), Parent = currentTile, Cost = currentTile.Cost + 1 },
	};

		possibleTiles.ForEach(tile => tile.SetDistance(targetTile.position));

		var maxX = 56 - 1;
		var maxY = 56 - 1;

		return possibleTiles
				.Where(tile => tile.position.x >= 0 && tile.position.x <= maxX)
				.Where(tile => tile.position.y >= 0 && tile.position.y <= maxY)
				.Where(tile => map[(int)tile.position.x, (int)tile.position.y] == 0 )
				.ToList();
	}


}
	



public class Tile
{
	public Vector2 position { get; set; }

	public int Cost { get; set; }
	public float Distance { get; set; }
	public float CostDistance => Cost + Distance;
	public Tile Parent { get; set; }

	

	//The distance is essentially the estimated distance, ignoring walls to our target. 
	//So how many tiles left and right, up and down, ignoring walls, to get there. 
	public void SetDistance(Vector2 target)
	{
		this.Distance = Vector2.Distance(position, target);
	}
}
