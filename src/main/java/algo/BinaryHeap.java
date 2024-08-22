package algo;

import java.util.*;


public class BinaryHeap {


    public List<Integer> elems;

    public BinaryHeap(List<Integer> elems) {
        this.elems = new ArrayList<>();
        elems.add(null); // 인덱스 계산을 편하게 하기 위해 첫번째 값은 null을 삽입해서 사용하지 않는다.
    }

    /**
     * 엘리먼트 삽입
     * @param value 신규 엘리먼트
     */
    public void insert(int value) {
        // 신규 엘리먼트 추가
        elems.add(value);
        // up heap 연산 수행
        percolateUp();
    }


    /**
     * 엘리먼트 삽입시 수행하는 up-heap 연산
     * 1. 엘리먼트를 가장 하위레벨의 가장 왼쪽으로 삽입한다. (배열로 표현할 경우 가장 마지막에 삽입)
     * 2. 부모 값과 비교해 값이 더 작은 경우 스왑한다. (가장 작은 값일 경우 루트까지 올라감)
     * parentIdx를 idx / 2로 줄여나가는 형태 -> 시간 복잡도는 O(logn)
     */
    private void percolateUp() {
        // 삽입한 엘리먼트 위치 (가장 마지막)
        int idx = elems.size() - 1;

        // 부모 노드 인덱스
        int parentIdx = idx / 2;

        while (parentIdx > 0) {
            // 부모노드가 더 크면 스왑
            if (elems.get(parentIdx) > elems.get(idx)) {
                // 현재 엘리먼트와 부모 노드의 값 스왑
                Collections.swap(elems, idx, parentIdx);
            }
            idx = parentIdx;
            parentIdx = idx / 2;
        }
    }

    /**
     * 엘리먼트 추출
     * @return 최소 힙이므로 가장 작은 값이 추출된다.
     */
    public int extract() {
        // 루트 노드 값 추출, 최소힙이므로 가장 작은 값
        int extracted = elems.get(1);

        // 루트에 가장 마지막 값 삽입
        int leaf = elems.size() - 1;
        elems.set(1, elems.get(leaf));
        elems.remove(leaf);

        // down-heap 연산 수행
        minHeapify(1);
        return extracted;
    }

    /**
     * 엘리먼트 추출 이후 Down heap 연산
     * 1. 추출 이후에 비어있는 루트에는 가장 마지막 엘리먼트가 올라간다.
     * 2. 자식 노드와 값을 비교해서 값을 비교해서 자식 노드보다 크면 스왑
     * 시간복잡도는 O(logn)
     * @param i 부모노드 인덱스
     */
    private void minHeapify(int i) {
        int left = i * 2;
        int right = i * 2 + 1;
        int minimum = i; // 부모 노드 값을 Min값으로 가정

        // 왼쪽 자식 노드가 부모 노드 보다 작다면 minimum 노드를 왼쪽 자식노드로 선언
        if (left <= elems.size() - 1 && elems.get(left) < elems.get(minimum)) {
            minimum = left;
        }

        if (right < elems.size() - 1 && elems.get(right) < elems.get(minimum)) {
            minimum = right;
        }

        if (minimum != i) {
            // 가장 작은 노드와 현재노드 값 스왑
            Collections.swap(elems, minimum, i);
            minHeapify(minimum);
        }
    }


}
