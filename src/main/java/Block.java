import java.util.Date;
public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;
    //Phương thức khởi tạo khối.
    public Block(String data,String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
// Phương thức tạo hash và đào khối sẽ được viết ở đây
    }
    public String calculateHash() {
        String calculatedhash = DigitalSignatures.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
//Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}