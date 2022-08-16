public class ArrayList {
    public void add(int index, int value) {
        if(index<0 || index > size) {
            // throw exception
        }
        
        if (size == capacity) {
            resize();
        }

        size++;
        for(int i = size-1; i >= index+1; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
    }

    private void resize() {
        capacity *= 2;
        int[] new_data = new int[capacity];
        for(int i = 0; i < size; i++) {
            new_data[i] = data[i];
        }
        data = new_data;
    }

    public void remove(int index) {
        size--;
        for (int = index; i < size; i++) {
            data[i] = data [i+1];
        }
    }
}