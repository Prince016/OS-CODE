public class Banker_Algo
{
    int x = 5;
    int y = 4;
    int need[][] = new int[x][y];
    int max[][];
    int allocated[][];
    int avail[];
    int safeSequence[] = new int[x];

    void resources_alloc()
    {
        allocated = new int[][] { { 0, 0, 1, 2 },
                { 1, 1, 0, 0 },
                { 1, 3, 5, 4 },
                { 0, 6, 3, 2 },
                { 0, 0, 1, 4 } };

        max = new int[][] { { 0, 0, 1, 2 },
                { 1, 7, 5, 0 },
                { 2, 3, 5, 6 },
                { 0, 6, 5, 2 },
                { 0, 6, 5, 6 } };


        avail = new int[] { 1, 5, 2, 0 };
    }

    void isSafe()
    {
        int count=0;

        boolean visited[] = new boolean[x];
        for (int i=0;i<x;i++)
        {
            visited[i]=false;
        }

        int temp[] = new int[y];
        for (int i=0;i<y;i++)
        {
            temp[i] = avail[i];
        }

        while(count<x)
        {
            boolean flag = false;
            for (int i=0;i<x;i++)
            {
                if (visited[i] == false)
                {
                    int j;
                    for (j=0;j<y;j++)
                    {
                        if (need[i][j]>temp[j])
                            break;
                    }
                    if(j==y)
                    {
                        safeSequence[count++]=i;
                        visited[i]=true;
                        flag=true;

                        for (j=0;j<y;j++)
                        {
                            temp[j]=temp[j]+allocated[i][j];
                        }
                    }
                }
            }
            if (flag==false)
            {
                break;
            }
        }
        if (count<y)
        {
            System.out.println("UNSAFE system");
        }
        else
        {
            System.out.print("SAFE Sequence:");
            for (int i=0;i<x;i++)
            {
                System.out.print("P"+safeSequence[i]);
                if (i!= x-1)
                    System.out.print(" -> ");
            }
        }
    }

    void calc_need()
    {
        System.out.println("Need Matrix");
        for (int i=0;i<x;i++)
        {
            for (int j=0;j<y;j++)
            {
                need[i][j] = max[i][j]-allocated[i][j];
                System.out.print(need[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Banker_Algo ba = new Banker_Algo();

        ba.resources_alloc();
        ba.calc_need();
        ba.isSafe();
    }
}
