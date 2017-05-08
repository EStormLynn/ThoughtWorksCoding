public class BowlingGame {

    public static int getBowlingScore(String bowlingCode)
	  {
		  String[] tmp=bowlingCode.split("\\|\\|");
		  String[] strs=tmp[0].split("\\|");
		  int[] sum=new int[22];
		  int[] flag=new int[10];
		  for(int i=0,j=0;i<strs.length;i++)
		  {
			  if(strs[i].length()>1)
			  {
				  char[] chars=strs[i].toCharArray();
				  if(chars[0]!='-')
				  {
					  sum[j++]=chars[0]-'0';
					  if(chars[1]=='/')
					  {
						  sum[j]=10-sum[j-1];
						  j++;
						  flag[i]=1;
					  }
					  else if(chars[1]=='-')
					  {
						  flag[i]=0;
						  sum[j++]=0;
					  }
					  else
					  {
						  sum[j++]+=(chars[1]-'0');
						  flag[i]=0;
					  }
				  }
				  else
				  {
					  sum[j++]=0;
					  if(chars[1]=='/')
					  {
						  sum[j++]=10;
						  flag[i]=1;
					  }
					  else if(chars[1]=='-')
					  {
						  flag[i]=0;
						  sum[j++]=0;
					  }
					  else
					  {
						  sum[j++]+=(chars[1]-'0');
						  flag[i]=0;
					  }
				  }
			  }
			  else
			  {
				  sum[j++]=10;
				  sum[j++]=0;
				  flag[i]=2;
			  }
		  }
		  if(tmp.length>1)
		  {
			  char[] c=tmp[1].toCharArray();
			  for(int i=0;i<c.length;i++)
			  {
				  if(c[i]=='X')
					  sum[20+i]=10;
				  else if(c[i]=='-')
					  sum[20+i]=0;
				  else
					  sum[20+i]=sum[20+i]+(c[i]-'0');
			  }
				  
		  }
		  int Ssum=0;
		  for(int i=0;i<9;i++)
		  {
			  if(flag[i]==0)
				  Ssum+=sum[2*i]+sum[2*i+1];
			  else if(flag[i]==1)
				  Ssum+=sum[2*i]+sum[2*i+1]+sum[2*i+2];
			  else
			  {
				  if(flag[i+1]<2)
					  Ssum+=sum[2*i]+sum[2*i+1]+sum[2*i+2]+sum[2*i+3];
				  else
					  Ssum+=sum[2*i]+sum[2*i+1]+sum[2*i+2]+sum[2*i+4];
			  }
		  }
		  Ssum+=sum[18]+sum[19]+sum[20]+sum[21];
	        return Ssum;
	  }
}
