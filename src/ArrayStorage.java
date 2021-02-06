import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int actualSize = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < actualSize; i++) {
            storage[i] = null;
        }
        actualSize = 0;
    }

    void save(Resume r) {
        storage[actualSize] = r;
        actualSize++;
    }

    Resume get(String uuid) {
        int index = find(uuid);
        if (index == -1) {
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = find(uuid);
        if (index >= 0) {
            storage[index] = storage[actualSize - 1];
            actualSize--;
        }
    }

    private int find(String uuid) {
        for (int i = 0; i < actualSize; i++) {
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
        return Arrays.copyOf(storage, actualSize);
    }

    int size() {
        return actualSize;
    }
}
