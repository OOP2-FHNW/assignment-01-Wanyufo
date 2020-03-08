package portfolio;

import portfolio.investments.Investment;
import portfolio.investments.Share;

import java.util.ArrayList;

public class Portfolio<T extends Investment>{
    ArrayList<T> portfolio = new ArrayList<>();

    public Portfolio() {
        super();
    }

    public boolean contains(T share) {
        for (T x : portfolio) {
            if ( x.equals(share)) return true;
        }
        return false;
    }

    public void buy(T share) {
        if (portfolio.contains(share)) this.getShare(share.getTitel()).setCount(share.getCount() + 1);
        else portfolio.add(share);
    }

    public void sell(String share, int i) {
        T invest = this.getShare(share);
        if (portfolio.contains(invest)) invest.setCount(invest.getCount() - i);
        if (portfolio.contains(invest) && invest.getCount() == 0) portfolio.remove(invest);
    }

    public T getShare(String share) {
        for (int i = 0; i < portfolio.size(); i++) {
            if (portfolio.get(i).getTitel().equals(share)) return portfolio.get(i);
        }
        return null;
    }
}
