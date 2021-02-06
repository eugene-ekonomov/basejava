import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int actualSize = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        actualSize = 0;
    }

    void save(Resume r) {
        storage[actualSize] = r;
        actualSize++;
    }

    Resume get(String uuid) {
        int position = find(uuid);
        if (position == -1) {
            return null;
        } else {
            return storage[position];
        }
    }

    void delete(String uuid) {
        int position = find(uuid);
        if (position >= 0) {
            if (actualSize > 1) {
                storage[position] = storage[actualSize - 1];
            }
            actualSize--;
        }
    }

    private int find(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        return actualSize;
    }
}
