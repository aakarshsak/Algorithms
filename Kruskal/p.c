/*
* @Author: Aakarsh
* @Date:   2019-03-13 22:29:06
* @Last Modified by:   Aakarsh
* @Last Modified time: 2019-03-14 00:28:51
*/


/*
	Kruskal's algorithm
	Input : a graph in the form of square matrix
	Output : a MST(Minimum spanning tree in the form of matrix)

	1. Sort all the edges in non-decreasing order of their weight.
	2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. If cycle is not formed, include this edge. Else, discard it.
	3. Repeat step#2 until there are (V-1) edges in the spanning tree.
*/
#include<stdio.h>
#include<stdlib.h>
#define INF 9999


//find function of union-find algorithm
int find(int *parent,int n)
{
	if(parent[n]==-1)
		return n; 
	return find(parent,parent[n]);
}


//unionSet function of union-find algorithm to find if cycle exist in a graph
void unionSet(int *parent,int src,int des)
{
	int x=find(parent,src);
	int y=find(parent,des);
	parent[x]=y;
}

//actual kruskal function to get the mst
void kruskals(int g[50][50],int mst[50][50],int v,int e,int edges[50][3])
{
	int parent[v],i,j;

	for(i=0;i<v;i++)
		parent[i]=-1;

	
	i=0,j=0;  //i is a edge count variable to count the numbere of edges in the MST 
	while(i<v-1 && j<e)
	{
		int src=edges[j][0];
		int des=edges[j][1];
		int w=edges[j][2];
		int x=find(parent,src);
		int y=find(parent,des);
		if(x!=y)
		{
			mst[src][des]=w;
			unionSet(parent,src,des);
			i++;
			j++;
		}
		else
			j++;
	}
}

int main()
{
	int i,j,v,e;
	int g[50][50],mst[50][50];

	printf("\nEnter the number of vertex and edges : ");
	scanf("%d%d",&v,&e);

	//initializing the minimum cost spannign  tree with INF
	for(i=0;i<v;i++)
	{
		for(j=0;j<v;j++)
		{
			mst[i][j]=INF;
		}
	}
	//Taking input from the user for the graph
	int x=0;
	int edges[50][3];
	for(i=0;i<v;i++)
	{
		for(j=0;j<v;j++)
		{
			scanf("%d",&g[i][j]);
			if(g[i][j]!=INF && i<j)
			{
				edges[x][0]=i;
				edges[x][1]=j;
				edges[x++][2]=g[i][j];
			}
		}
	}
	//Step-1. Sort all the edges in non-decreasing order of their weight.
	for(i=0;i<e;i++)
	{
		for(j=0;j<e-1-i;j++)
		{
			if(edges[j][2] > edges[j+1][2])
			{
				//swapping the src vertices of edges
				int temp=edges[j][0];edges[j][0]=edges[j+1][0];edges[j+1][0]=temp;
				//swapping the des vertices of edges
				temp=edges[j][1];edges[j][1]=edges[j+1][1];edges[j+1][1]=temp;
				//swapping the weight of the edges
				temp=edges[j][2];edges[j][2]=edges[j+1][2];edges[j+1][2]=temp;
			}
		}
	}
	//Step 2 and 3 with the function
	//calling the kruskal function to find the minimum cost spanning tree
	kruskals(g,mst,v,x,edges);

	//printing the minimum cost spanning tree
	printf("\n\nMinimum cost spanning tree : \n");
	for(i=0;i<v;i++)
	{
		for(j=0;j<v;j++)
		{
			printf("%d ",mst[i][j]);
		}
		printf("\n");
	}
	return 0;
}