/**
 * @City
 * @City
 */
public class TestAtoincDemo {
}

 class AtomiceDemo implements Runnable
{
    private int serinlNumber=0;
    public void run()
    {
        try {
            Thread.sleep(200);
        }catch(InterruptedException e) {
        }

        System.out.println(Thread.currentThread().getName()+":"+getSerinalNumber());
    }
    public int getSerinalNumber(){
        return serinlNumber++;
    }
}