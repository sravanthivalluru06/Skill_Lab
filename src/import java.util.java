import java.util.ArrayList;
import java.util.List;
interface Auctioneer {
    void registerBidder(Bidder bidder);
    void removeBidder(Bidder bidder);
    void notifyBidders(String message);
}
class ConcreteAuctioneer implements Auctioneer {
    private List<Bidder> bidders;

    public ConcreteAuctioneer() {
        this.bidders = new ArrayList<>();
    }
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }
    public void removeBidder(Bidder bidder) {
        bidders.remove(bidder);
    }
    public void notifyBidders(String message) {
        for (Bidder bidder : bidders) {
            bidder.update(message);
        }
    }

    public void auctionEvent(String event) {
        System.out.println("Auction Event: " + event);
        notifyBidders(event);
    }
}
interface Bidder {
    void update (String message);
}
class ConcreteBidder implements Bidder {
    private String name;

    public ConcreteBidder(String name) {
        this.name = name;
    }
    public void update(String message) {
        System.out.println("Bidder " + name + " received update: " + message);
    }
}
 class Main {
    public static void main (String [] args) {
        ConcreteAuctioneer auctioneer = new ConcreteAuctioneer();
        Bidder bidder1 = new ConcreteBidder("Alice");
        Bidder bidder2 = new ConcreteBidder("Bob");
        Bidder bidder3 = new ConcreteBidder("Charlie");
        auctioneer.registerBidder(bidder1);
        auctioneer.registerBidder(bidder2);
        auctioneer.auctionEvent("Item is now available for bidding.");
        auctioneer.auctionEvent("Bidding has started.");
        auctioneer.registerBidder(bidder3);
        auctioneer.auctionEvent("Bidding is about to end.");
        auctioneer.removeBidder(bidder1);
        auctioneer.auctionEvent("Bidding has ended.");
    }
}
