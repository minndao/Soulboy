from sklearn.dummy import DummyClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, f1_score
from sklearn.model_selection import cross_val_score


REQUIRED_NAMES = [
    "le",
    "y_train",
    "y_test",
    "X_trained_mi_pd",
    "y_train_encoded",
    "X_test_mi_pd",
    "y_test_encoded",
]


def run_diagnosis(le, y_train, y_test, X_trained_mi_pd, y_train_encoded, X_test_mi_pd, y_test_encoded):
    # Quick diagnosis:
    # - Dummy baseline tells you how far a no-skill model gets.
    # - Balanced logistic regression tells you whether the features still carry signal.
    print("Target classes:", list(le.classes_))
    print("\nTrain class distribution (%):")
    print((y_train.value_counts(normalize=True) * 100).round(2))
    print("\nTest class distribution (%):")
    print((y_test.value_counts(normalize=True) * 100).round(2))

    majority_share = y_test.value_counts(normalize=True).max()
    print(f"\nMajority-class share in test set: {majority_share:.4f}")

    dummy = DummyClassifier(strategy='most_frequent', random_state=42)
    dummy.fit(X_trained_mi_pd, y_train_encoded)
    dummy_pred = dummy.predict(X_test_mi_pd)
    print(f"Dummy accuracy: {accuracy_score(y_test_encoded, dummy_pred):.4f}")
    print(f"Dummy macro F1: {f1_score(y_test_encoded, dummy_pred, average='macro'):.4f}")

    balanced_lr = LogisticRegression(max_iter=1000, class_weight='balanced', random_state=42)
    lr_scores = cross_val_score(
        balanced_lr,
        X_trained_mi_pd,
        y_train_encoded,
        cv=3,
        scoring='f1_macro',
        n_jobs=-1,
    )
    print(f"Balanced Logistic Regression CV F1-macro: {lr_scores.mean():.4f} ± {lr_scores.std():.4f}")


if __name__ == "__main__":
    missing = [name for name in REQUIRED_NAMES if name not in globals()]

    if missing:
        print("This script depends on variables that are created in the notebook, so it cannot run standalone.")
        print("Missing names:", ", ".join(missing))
        print("Paste this code into the notebook after the preprocessing and encoding cells, or call run_diagnosis(...) with the required variables.")
    else:
        run_diagnosis(
            le,
            y_train,
            y_test,
            X_trained_mi_pd,
            y_train_encoded,
            X_test_mi_pd,
            y_test_encoded,
        )