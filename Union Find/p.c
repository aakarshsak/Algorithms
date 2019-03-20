/*	
	Union find algorith to find if a cycle exist or not in a graph
	Input:A graph in the form  of  a square matrix
	Output:true if cycle exist otherwise false  	
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#define INF 9


//Function to find the vertex in the graph
int find(int *parent,int n)
{
	if(parent[n]==-1)
		return n;
	return find(parent,parent[n]);
}


//Function union to make a bigger set of two smaller sets
void unionSet(int *parent,int src,int des)
{
	int x=find(parent,src);
	int y=find(parent,des);
	parent[x]=y;
}
//Function to find out if there is a cycle in  the graph or not
bool isCycle(int g[50][50],int v,int e,int ed[50][2])
{
	int parent[v],x,y,i;
	for(i=0;i<v;i++)
	{
		parent[i]=-1;
	}

	for(i=0;i<e;i++)
	{
		int src=ed[i][0];
		int des=ed[i][1];
		x=find(parent,src);
		y=find(parent,des);
		if(x==y)
		{
			return 1;
		}
		unionSet(parent,x,y);
	}

	return 0;
}
//main function
int main()
{
	int i,e,v,j,g[50][50];

	printf("\nEnter the number of vertices and edges :\t");
	scanf("%d%d",&v,&e);

	int edges[e][2];
	//taking input from the user for the graph
	int x=0;
	for(i=0;i<v;i++)
	{
		for(j=0;j<v;j++)
		{
			scanf("%d",&g[i][j]);

			//defining an array of edges to g[i][j]!=INF is to check whethere 
			//there is an edge between two node and i<j so that edge does not repeat  
			if(g[i][j]!=INF && i<j)
			{
				edges[x][0]=i;
				edges[x++][1]=j;
			}
		}
	}

	if(isCycle(g,v,e,edges))
	{
		printf("\nCycle exist.....");
	}
	else
	{
		printf("\nCycle does not exist......");
	}
	return 0;
}