package iuh.fit.thanhoangthienthien_tuan04.bai03.beans;


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

    // thêm sản phẩm
    public void addProduct(Product p, int quantity) {
        for (CartItemBean item : items) {
            if (item.getProduct().getId() == p.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        // Nếu chưa có thì thêm mới
        items.add(new CartItemBean(p, quantity));
    }

    // xóa sản phẩm
    public void removeProduct(int productID) {
        items.removeIf(item -> item.getProduct().getId() == productID);
    }

    // cập nhật số lương

    public void updateQuantity(int productId, int quantity) {
        for (CartItemBean item : items) {
            if (item.getProduct().getId() == productId) {
                if (quantity > 0) {
                    item.setQuantity(quantity);
                } else {
                    // nếu nhập <= 0 thì xóa luôn sản phẩm
                    removeProduct(productId);
                    ;
                }
                return;
            }
        }
    }

    // tính tổng tiền giỏ hàng
    public double getTotal() {
        double total = 0;
        for (CartItemBean item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    // xóa hết giỏ hàng
    public void clear() {
        items.clear();
    }
}
