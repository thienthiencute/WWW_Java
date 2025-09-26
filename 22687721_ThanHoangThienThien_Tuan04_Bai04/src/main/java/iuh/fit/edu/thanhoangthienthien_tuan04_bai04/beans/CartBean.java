package iuh.fit.edu.thanhoangthienthien_tuan04_bai04.beans;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
    private List<CartItemBean> items;

    public CartBean(List<CartItemBean> items) {
        this.items = items;
    }

    public CartBean() {
        items = new ArrayList<>();
    }

    public List<CartItemBean> getItems() {
        return items;
    }

    public void addBook(Book book, int quantity) {
        for (CartItemBean item : items) {
            if (item.getBook().getId().equals(book.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItemBean(book, quantity));
    }

    public void removeBook(String bookId) {

        items.removeIf(item -> item.getBook().getId().equals(bookId));
    }

    public void updateBookQuantity(String bookId, int quantity) {
        for (CartItemBean item : items) {
            if (item.getBook().getId().equals(bookId)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(CartItemBean::getTotal).sum();
    }

    // xóa hết giỏ hàng
    public void clear() {
        items.clear();
    }
}

