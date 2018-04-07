package Lab10;import java.util.ArrayList;import java.util.List;import java.util.Random;/** * A class that represents a message. * * @author Kirsty Alexandra Nguegang * @author Anna Bieszczad * @version 4/3/2018 */public class Message{    private String originalMessage;    private int packetLength;    private String retrievedMessage;    private List<Packet> sentPackets;    private List<Packet> receivedPackets;    public final static int SMALLEST_PACKET_LENGTH = 3;    /**     * Constructor sets this.originalMessage to the input given by the user     * sets this.packetLength to the packet length given by the user     *     * @param theMessage     * @param thePacketLength     */    public Message(String theMessage, int thePacketLength)    {        this.originalMessage = theMessage;        this.packetLength = thePacketLength;        this.retrievedMessage = "";        this.sentPackets = new ArrayList<>();        this.receivedPackets = new ArrayList<>();    }    /**     * Breaks the  original message to a collection of packets.     * The created packet objects are saved to this.sentPackets     */    public void send()    {        // TODO Project 5        System.out.println("Message send method - IMPLEMENT ME");        for (int i = 0; i < this.originalMessage.length(); i++)        {            if (i % packetLength == 0)            {                this.sentPackets.add(new Packet(i, this.originalMessage.substring(i, i + this.packetLength)));            }        }           // The content of created packet collection        System.out.println("Sent packets:" + this.sentPackets);    }    /**     * Simulates the receipt of the packets of a message.     * Calls the private shuffle method so the packets     * are not in any particular order. They are saved to this.receivedPackets     */    public void receive()    {        int numberOfPackets = this.sentPackets.size();        this.receivedPackets = new ArrayList<>(this.sentPackets);        // shuffle the packets to simulate their arrival order        shuffle(this.receivedPackets, numberOfPackets);        System.out.println("Received packets:" + this.receivedPackets);    }    public String getOriginalMessage()    {        return this.originalMessage;    }    public String getRetrievedMessage()    {        return this.retrievedMessage;    }    /**     * This is a private method that recursively shuffles the packet     * objects so they are arranged in no particular order     *     * @param packetList     * @param numberOfPackets     */    private void shuffle(List<Packet> packetList, int numberOfPackets)    {        // TODO Project 5        if (numberOfPackets > 1)        {            // swap packet at index numberOfPackets - 1 and a random index            System.out.println("Message shuffle method - IMPLEMENT ME RECURSIVELY");        }    }    /**     *   Constructs the message back and saves it in this.retrievedMessage     *   utilizes SortedLinkedList to arrange the packet objects according     *   to their sequence number     */    public void assemble()    {        // TODO Project 5        StringBuilder messageBuilder = new StringBuilder();        SortedListInterface<Packet> sortedMessage = new SortedLinkedList<>();        System.out.println("Message assemble method - IMPLEMENT ME");        // add packets to the sorted list        // put pieces of message together        // set this.retrievedMessage to the reconstructed string    }}